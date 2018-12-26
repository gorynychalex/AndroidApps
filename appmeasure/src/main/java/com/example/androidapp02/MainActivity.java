package com.example.androidapp02;

import android.icu.text.MeasureFormat;
import android.icu.util.Measure;
import android.icu.util.MeasureUnit;
import android.icu.util.ULocale;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    DatePicker datePicker;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        datePicker = findViewById(R.id.datePicker);

//        MeasureFormat measureFormat = MeasureFormat.getInstance(ULocale.ENGLISH, MeasureFormat.FormatWidth.SHORT);
//        Measure measure = new Measure(23, MeasureUnit.KILOGRAM);

//        textView.setText(measureFormat.format(measure).toString());


        datePicker.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                textView.setText(String.valueOf(datePicker.getDayOfMonth()) + "." + String.valueOf(datePicker.getMonth()) + "." + String.valueOf(datePicker.getYear()));
            }
        });



    }
}
