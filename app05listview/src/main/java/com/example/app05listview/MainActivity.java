package com.example.app05listview;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Список тестов
    public static String[] tests = new String[]{"Java", "Android", "Patterns"};

    // Переменная для адаптера списка
    ArrayAdapter<String> adapter;

    // Переменная для кнопки
    Button button;

    // Переменная списка
    ListView listView;

    // Переменная для хранения выбора позиции
    int selectedPosition;

    // Новое намерение
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация списка
        listView = findViewById(R.id.list_view);

        // Кнопка выбора теста
        button = findViewById(R.id.buttonChoose);

        // Инициализация адаптера
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, getResources().getStringArray(R.array.tests));

        // Назначение адаптера списку
        listView.setAdapter(adapter);

        // "Слушатель" на событие выбора пункта списка
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                Toast.makeText(getApplicationContext(), ((TextView) itemClicked).getText() + " , position = " + position, Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", String.valueOf(position));

                selectedPosition = position;
            }
        });

        // Назначение слушателя кнопке. Инициализация нажатия на кнопку
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Инициализация намерения
                intent = new Intent(MainActivity.this, QuestionActivity.class);

                Log.d("MainActivity", String.valueOf(selectedPosition));
                // Передача параметра выбранной позиции в другое окно
                intent.putExtra("position", selectedPosition);

                // Запуск новой активности
                startActivity(intent);
            }
        });
    }
}
