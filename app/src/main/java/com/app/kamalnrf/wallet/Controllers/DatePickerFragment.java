package com.app.kamalnrf.wallet.Controllers;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import com.app.kamalnrf.wallet.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//For backward compatibility...

/**
 * Created by kamalnrf on 14/4/16.
 */

/**
 * When using an AlertDialog, it is a good idea to wrap it in an instance of
 DialogFragment, a subclass of Fragment. It is possible to display
 an AlertDialog without a DialogFragment, but it is not recommended.
 */
public class DatePickerFragment extends DialogFragment
{
    public static final String EXTRA_DATE = "com.example.kamalnrf.criminalintent.date";
    public static final String ARG_DATE = "date";

    private DatePicker mDatePicker;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        Date date = (Date) getArguments().getSerializable(ARG_DATE);

        Calendar calander = Calendar.getInstance();
        calander.setTime(date);

        int year = calander.get(Calendar.YEAR);
        int month = calander.get(Calendar.MONTH);
        int day = calander.get(Calendar.DATE);

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_date, null);

        mDatePicker = (DatePicker) v.findViewById(R.id.dialog_date_date_picker);
        mDatePicker.init(year, month, day, null);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int year = mDatePicker.getYear();
                                int month = mDatePicker.getMonth();
                                int day = mDatePicker.getDayOfMonth();

                                Date date = new GregorianCalendar(year, month, day).getTime();
                                sendResult(Activity.RESULT_OK, date);

                            }
                        })
                .create();
    }

    private void sendResult (int resultCode, Date date)
    {
        if (getTargetFragment() == null)
        {
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_DATE, date);

        getTargetFragment()
                .onActivityResult(getTargetRequestCode(), resultCode, intent);
    }

    public static DatePickerFragment newInstanse(Date date)
    {
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATE, date);

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
