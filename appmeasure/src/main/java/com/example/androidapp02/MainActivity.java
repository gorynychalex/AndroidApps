package com.example.androidapp02;

import android.icu.text.MeasureFormat;
import android.icu.util.Measure;
import android.icu.util.MeasureUnit;
import android.icu.util.ULocale;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MeasureFormat measureFormat = MeasureFormat.getInstance(ULocale.ENGLISH, MeasureFormat.FormatWidth.SHORT);
        Measure measure = new Measure(23, MeasureUnit.KILOGRAM);

        System.out.println(measureFormat.format(measure));
    }
}
