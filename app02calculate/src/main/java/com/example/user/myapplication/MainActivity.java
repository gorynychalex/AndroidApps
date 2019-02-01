package com.example.user.myapplication;

/** Расчетная задача
 *  Пример ввода данных из полей
 */

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //    Объявление переменных
    EditText input1;
    EditText input2;
    Button btnResult;
    TextView output;
    TextView operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //        Инициализация полей
        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);
        output = (TextView) findViewById(R.id.output);
        btnResult = (Button) findViewById(R.id.button);

        //         Определение оператора
        operation = findViewById(R.id.operation);
        //          Задание оператора
        operation.setText("+");
    }

    //    Метод реакции нажатия на кнопку
    public void clickButton(View view){

        //Определение содержимого полей ввода
        String s1 = input1.getText().toString();
        String s2 = input1.getText().toString();

        //Приведение к целочисленным значениям из строк
        int x1 = Integer.parseInt(s1);
        int x2 = Integer.parseInt(s2);

        // Вычисление результата (х1+х2) и приведение к строке
        output.setText(String.valueOf(x1 + x2));
    }

}
