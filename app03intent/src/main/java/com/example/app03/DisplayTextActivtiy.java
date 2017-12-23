package com.example.app03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayTextActivtiy extends AppCompatActivity {

    //Объявление полей
    Intent intent;
    TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_text_activtiy);

        textViewMessage = findViewById(R.id.message);

        //Получение переданного объекта НАМЕРЕНИЕ (из первой активности)
        intent = getIntent();

        String inputMessage = intent.getStringExtra("message");
        String inputMessage2 = intent.getStringExtra("message2");

        //Внесение переданных данных в текстовое поле
        textViewMessage.setText(inputMessage);
    }
}
