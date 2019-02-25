package ru.popovich.app071roomdb;

// Простая реализация Room Persistence

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import ru.popovich.app071roomdb.db.QuizDatabase;
import ru.popovich.app071roomdb.db.model.Quiz;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    // Объявление переменной для базы данных
    QuizDatabase database;

    ListView listView;
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация объекта базы данных
        // @.allowMainThreadQueries() - работа в главном потоке
        database = Room.databaseBuilder(getApplicationContext(),QuizDatabase.class,"quizdb")
                .allowMainThreadQueries()
                .build();


        // Если база пуста, добавляем записи
        if(database.quizDao().getAll().isEmpty()){

            Log.d(TAG,"Database is empty! Add quizes: ");

            // Создание списка и инициализация
            List<Quiz> quizzes = new ArrayList<Quiz>();
            // Добавление новых записей
            quizzes.add(new Quiz("Java")); quizzes.add(new Quiz("Android")); quizzes.add(new Quiz("DataBases"));

            // Внесение данных списка в базу данных
            database.quizDao().insertAll(quizzes);
        }


        listView = findViewById(R.id.list_view);
        createList();


    }


    public void quizAdd(View view) {

        EditText editText = findViewById(R.id.name_add);
        if(editText.getText().toString() != null)
            database.quizDao().insert(new Quiz(editText.getText().toString()));

        createList();

    }

    public void createList(){
        List<String> quiz_names = new ArrayList<>();

        // Вывод в лог данных
        // Создание простого массива
        for(Quiz q :database.quizDao().getAll()) {
            Log.d(TAG, "quiz name = (" + q.getId() + ") " + q.getName());
            quiz_names.add(q.getId() + ") " + q.getName());
        }

        listView.
                setAdapter(
                        new ArrayAdapter<String>(this,
                                android.R.layout.simple_list_item_1,
                                quiz_names)
                );

    }
}
