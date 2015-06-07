/*
 * Copyright (C) 2008 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.portaura.zxing;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;


import com.cn.daming.deskclock.R;
import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;

/**
 * A base class for the Android-specific barcode handlers. These allow the app
 * to polymorphically suggest the appropriate actions for each data type.
 * 
 * This class also contains a bunch of utility methods to take common actions
 * like opening a URL. They could easily be moved into a helper object, but it
 * can't be static because the Activity instance is needed to launch an intent.
 * 
 * @author dswitkin@google.com (Daniel Switkin)
 */
public abstract class ResultHandler {

	private static final String TAG = ResultHandler.class.getSimpleName();

	private static final DateFormat DATE_FORMAT;
	static {
		DATE_FORMAT = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
		DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("GMT"));
	}
	private static final DateFormat DATE_TIME_FORMAT = new SimpleDateFormat(
			"yyyyMMdd'T'HHmmss", Locale.ENGLISH);

	public static final int MAX_BUTTON_COUNT = 4;

	private final ParsedResult result;
	private final Activity activity;
	private final Result rawResult;

	ResultHandler(Activity activity, ParsedResult result) {
		this(activity, result, null);
	}

	ResultHandler(Activity activity, ParsedResult result, Result rawResult) {
		this.result = result;
		this.activity = activity;
		this.rawResult = rawResult;
	}

	public ParsedResult getResult() {
		return result;
	}

	Activity getActivity() {
		return activity;
	}

	/**
	 * Some barcode contents are considered secure, and should not be saved to
	 * history, copied to the clipboard, or otherwise persisted.
	 * 
	 * @return If true, do not create any permanent record of these contents.
	 */
	public boolean areContentsSecure() {
		return false;
	}

	/**
	 * Create a possibly styled string for the contents of the current barcode.
	 * 
	 * @return The text to be displayed.
	 */
	public String getDisplayContents() {
		String contents = result.getDisplayResult();
		return contents.replace("\r", "");
	}

	/**
	 * A convenience method to get the parsed type. Should not be overridden.
	 * 
	 * @return The parsed type, e.g. URI or ISBN
	 */
	public final ParsedResultType getType() {
		return result.getType();
	}

	/**
	 * Sends an intent to create a new calendar event by prepopulating the Add
	 * Event UI. Older versions of the system have a bug where the event title
	 * will not be filled out.
	 * 
	 * @param summary
	 *            A description of the event
	 * @param start
	 *            The start time as yyyyMMdd or yyyyMMdd'T'HHmmss or
	 *            yyyyMMdd'T'HHmmss'Z'
	 * @param end
	 *            The end time as yyyyMMdd or yyyyMMdd'T'HHmmss or
	 *            yyyyMMdd'T'HHmmss'Z'
	 * @param location
	 *            a text description of the event location
	 * @param description
	 *            a text description of the event itself
	 */
	final void addCalendarEvent(String summary, String start, String end,
			String location, String description) {
		Intent intent = new Intent(Intent.ACTION_EDIT);
		intent.setType("vnd.android.cursor.item/event");
		long startMilliseconds = calculateMilliseconds(start);
		intent.putExtra("beginTime", startMilliseconds);
		boolean allDay = start.length() == 8;
		if (allDay) {
			intent.putExtra("allDay", true);
		}
		long endMilliseconds;
		if (end == null) {
			if (allDay) {
				// + 1 day
				endMilliseconds = startMilliseconds + 24 * 60 * 60 * 1000;
			} else {
				endMilliseconds = startMilliseconds;
			}
		} else {
			endMilliseconds = calculateMilliseconds(end);
		}
		intent.putExtra("endTime", endMilliseconds);
		intent.putExtra("title", summary);
		intent.putExtra("eventLocation", location);
		intent.putExtra("description", description);
		launchIntent(intent);
	}

	private static long calculateMilliseconds(String when) {
		if (when.length() == 8) {
			// Only contains year/month/day
			Date date;
			synchronized (DATE_FORMAT) {
				date = DATE_FORMAT.parse(when, new ParsePosition(0));
			}
			// Note this will be relative to GMT, not the local time zone
			return date.getTime();
		} else {
			// The when string can be local time, or UTC if it ends with a Z
			Date date;
			synchronized (DATE_TIME_FORMAT) {
				date = DATE_TIME_FORMAT.parse(when.substring(0, 15),
						new ParsePosition(0));
			}
			long milliseconds = date.getTime();
			if (when.length() == 16 && when.charAt(15) == 'Z') {
				Calendar calendar = new GregorianCalendar();
				int offset = calendar.get(Calendar.ZONE_OFFSET)
						+ calendar.get(Calendar.DST_OFFSET);
				milliseconds += offset;
			}
			return milliseconds;
		}
	}

	// Use public Intent fields rather than private GMail app fields to specify
	// subject and body.
	final void sendEmailFromUri(String uri, String email, String subject,
			String body) {
		Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse(uri));
		if (email != null) {
			intent.putExtra(Intent.EXTRA_EMAIL, new String[] { email });
		}
		putExtra(intent, Intent.EXTRA_SUBJECT, subject);
		putExtra(intent, Intent.EXTRA_TEXT, body);
		intent.setType("text/plain");
		launchIntent(intent);
	}

	final void openURL(String url) {
		launchIntent(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
	}

	void launchIntent(Intent intent) {
		if (intent != null) {
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
			Log.d(TAG, "Launching intent: " + intent + " with extras: "
					+ intent.getExtras());
			try {
				activity.startActivity(intent);
			} catch (ActivityNotFoundException e) {
				AlertDialog.Builder builder = new AlertDialog.Builder(activity);
				builder.setTitle(R.string.app_name);
				builder.setPositiveButton(R.string.button_ok, null);
				builder.show();
			}
		}
	}

	private static void putExtra(Intent intent, String key, String value) {
		if (value != null && value.length() > 0) {
			intent.putExtra(key, value);
		}
	}

}
