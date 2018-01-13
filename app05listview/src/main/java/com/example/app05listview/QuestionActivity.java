package com.example.app05listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by user on 13.01.2018.
 */

public class QuestionActivity extends AppCompatActivity{

    // Объявление переменных
    TextView textView;
    Intent inputIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // Инициализация текстового поля
        textView = findViewById(R.id.test_name);

        // Получение входного "намерения"
        inputIntent = getIntent();

        // Получение переменной position по ключу
        int position = inputIntent.getIntExtra("position",0);

        Log.d("QuestionActivity", String.valueOf(position));

        // Отображение соотвествующего пункта
        textView.setText(getResources().getStringArray(R.array.tests)[position]);

    }
}
