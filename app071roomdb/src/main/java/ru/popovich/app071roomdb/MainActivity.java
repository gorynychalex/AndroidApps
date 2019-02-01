package ru.popovich.app071roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import ru.popovich.app071roomdb.db.QuizDatabase;
import ru.popovich.app071roomdb.db.model.Quiz;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    // Объявление переменной для базы данных
    QuizDatabase database;

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

        // Вывод в лог данных
        for(Quiz q :database.quizDao().getAll()) {
            Log.d(TAG, "quiz name = " + q.getName());
        }
    }
}
