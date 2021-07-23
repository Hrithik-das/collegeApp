package com.example.signin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import java.util.Calendar;
import java.util.Date;

public class calanderFrag extends Fragment {
    private View view;
    private CalendarView calendarview;

    @Override
    public void onStart() {
        super.onStart();
        Date date = new Date();
        long dt = date.getTime();
        calendarview = view.findViewById(R.id.calendarview);
        calendarview.setDate(dt);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_calander, container, false);
        return view;
    }
}