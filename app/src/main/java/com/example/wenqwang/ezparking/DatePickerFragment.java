package com.example.wenqwang.ezparking;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by wenqwang on 2017/2/25.
 */

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        month+=month;
        Intent intent = new Intent("date_picker");
        intent.putExtra("type", "1");
        intent.putExtra("year",""+year);
        intent.putExtra("month",""+month);
        intent.putExtra("day",""+day);
        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intent);
    }
}