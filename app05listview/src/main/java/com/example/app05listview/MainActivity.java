package com.example.app05listview;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app05listview.data.QuizData;
import com.example.app05listview.model.Quiz;

public class MainActivity extends AppCompatActivity {

    // Список тестов -> Замена на вывод списка из QuizData.class
    // public static String[] tests = new String[]{"Java", "Android", "Patterns"};
    private String[] tests;

    // Переменная для адаптера списка
    ArrayAdapter<String> adapter;

    // Переменная для кнопки
    Button button;

    // Переменная списка
    ListView listView;

    // Переменная для хранения выбора позиции
    int selectedPosition;

    // Переменная для сохранения пункта
    String testName;

    // Новое намерение
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация списка
        listView = (ListView) findViewById(R.id.list_view);

        // Кнопка выбора теста
        button = (Button) findViewById(R.id.buttonChoose);

        // Генерация данных тестов
        QuizData.setList();

        // Инициализация начальных переменных для заполнения списка тестов
        int i=0; tests = new String[QuizData.getQuizs().size()];

        // Подготовка массива @список тестов из QuizData.class
        for(Quiz quiz: QuizData.getQuizs()){
            tests[i++] = quiz.getName();
        }

        // Инициализация адаптера с предустановленной разметкой пунктов
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tests);

        // Назначение адаптера списку
        listView.setAdapter(adapter);

        // "Слушатель" на событие выбора пункта списка
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                Toast.makeText(getApplicationContext(),((TextView) itemClicked).getText() + " , position = " + position, Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", String.valueOf(position));

                selectedPosition = position;

                testName = ((TextView) itemClicked).getText().toString();
            }
        });

        // Назначение слушателя кнопке. Инициализация нажатия на кнопку
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Инициализация намерения для вызова следующей активности
                intent = new Intent(MainActivity.this, QuestionActivity.class);

                // Передача параметров выбранной позиции и наименования в следующее окно
                intent.putExtra("position", selectedPosition);
                intent.putExtra("test", testName);

                // Запуск новой активности
                startActivity(intent);
            }
        });
    }
}
