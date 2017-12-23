package com.example.app04lifecycle;

// https://developer.android.com/guide/components/activities.html#Lifecycle

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    //Метка для журналирования
    private static final String TAG = "Lifecycle";

    //Создание активности
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"Создание активности: onCreate()");
    }

    //Запуск активности
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"Запуск активности: onStart()");
    }

    //Возобновление активности
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"Возобновление активности: onResume()");
    }

    //Метод для приостановки
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"Пауза: onPause()");
    }

    //Метод остановки
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"Остановка активности: onStop()");
    }

    //Уничтожение активности
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Уничтожение активности: onDestroy()");
    }
}
