package com.yukang.selecttimedemo;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends Activity {

	private DatePicker dp;
	private TimePicker tp;
	private TextView tvTime;
	private int mYear, mMonth, mDay, mHour, mMinute;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dp = (DatePicker) findViewById(R.id.date_picker);
		tp = (TimePicker) findViewById(R.id.time_picker);
		tvTime = (TextView) findViewById(R.id.tvTime);
		Calendar calendar = Calendar.getInstance();
		mYear = calendar.get(Calendar.YEAR);
		mMonth = calendar.get(Calendar.MONTH);
		mDay = calendar.get(Calendar.DAY_OF_MONTH);
		mHour = calendar.get(Calendar.HOUR_OF_DAY);
		mMinute = calendar.get(Calendar.MINUTE);
		updateDisplay();
		dp.init(mYear, mMonth, mDay, new DatePicker.OnDateChangedListener() {

			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				mYear = year;
				mMonth = monthOfYear;
				mDay = dayOfMonth;
				updateDisplay();
			}
		});
		tp.setOnTimeChangedListener(new OnTimeChangedListener() {

			@Override
			public void onTimeChanged(TimePicker view, int hour, int minute) {
				mHour = hour;
				mMinute = minute;
				updateDisplay();
			}
		});
	}

	private void updateDisplay() {
		tvTime.setText(new StringBuilder().append(mYear).append("-").append(format(mMonth + 1)).append("-")
				.append(format(mDay)).append(" ").append(format(mHour)).append(":").append(format(mMinute)));
	}

	private String format(int x) {
		String s = "" + x;
		if (s.length() == 1)
			s = "0" + s;
		return s;
	}

}
