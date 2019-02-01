package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("КОНТРОЛЬ ЗНАНИЙ",true);
        editor.putBoolean("ПЕРЕМЕШИВАТЬ ВОПРОСЫ", true);
        editor.commit();

        sp.getBoolean("КОНТРОЛЬ ЗНАНИЙ", true);
        sp.getBoolean("ПЕРЕМЕШИВАТЬ ВОПРОСЫ", true);


        String[] strings = getResources().getStringArray(R.array.array1);
        for(String s: strings){
            Log.d("Activity", s);
        }


    }
}
