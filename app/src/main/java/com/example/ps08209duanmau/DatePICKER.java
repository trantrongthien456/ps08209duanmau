package com.example.ps08209duanmau;

import android.support.v4.app.DialogFragment;

import java.util.Calendar;

public class DatePICKER extends DialogFragment {
    private int year, month, day;

    public DatePICKER() {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
    }
}