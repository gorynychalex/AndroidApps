package com.example.app03;

//https://developer.android.com/training/basics/firstapp/building-ui.html

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Объявление полей intent
    Intent intent;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Метод вызываемый при нажатии на кнопку "Передать" (задается в xml)
    public void sendMessage(View view) {

        //Создание объекта НАМЕРЕНИЕ. В параметрах класс второй активности
        intent = new Intent(this, DisplayTextActivtiy.class);
        editText1 = findViewById(R.id.editText1);

        //Параметры передаваемые в полях
        intent.putExtra("message",editText1.getText().toString());
        intent.putExtra("message2", "My message2");

        //Запуск новой экземпляра второй активности
        startActivity(intent);
    }
}
