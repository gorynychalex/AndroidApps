package com.example.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 28.12.2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String TAG = "DBHelper";

    // Переменные базы данных
    public static final String DB_NAME = "mydatabase";
    public static final int DB_VERSION = 5;

    // Таблица тесты и ее поля: [quiz] { id, text }
    public static final String TABLE_QUIZ = "quiz";
    public static final String TABLE_QUIZ_ID = "_id";
    public static final String TABLE_QUIZ_NAME = "question_text";

    // Таблица вопросы и ее поля: [questions] { id, quiz_id, text }
    public static final String TABLE_QUESTIONS = "questions";
    public static final String TABLE_QUESTION_ID = "_id";
    public static final String TABLE_QUESTION_QUIZ_ID = "quiz_id";
    public static final String TABLE_QUESTION_TEXT = "question_text";

    // Таблица вариантов ответов и поля: [options] { id, quiestion_id, text, correct }
    public static final String TABLE_OPTIONS = "options";
    public static final String TABLE_OPTION_ID = "_id";
    public static final String TABLE_OPTION_QUESTION_ID = "question_id";
    public static final String TABLE_OPTION_TEXT = "option_text";
    public static final String TABLE_OPTION_CORRECT = "option_correct";


    // Массив для первичного заполнения тестов
    String[] tests = {"Java", "Android", "Patterns", "Gradle"};

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // Создание таблицы тестов
        sqLiteDatabase.execSQL("create table " + TABLE_QUIZ + "("
                + TABLE_QUIZ_ID + " integer primary key, "
                + TABLE_QUIZ_NAME + " text"
                + ")"
        );

        // Создание таблицы вопросов. Внешний ключ указывает на таблицу тестов
        sqLiteDatabase.execSQL("create table " + TABLE_QUESTIONS + "("
                + TABLE_QUESTION_ID + " integer primary key, "
                + TABLE_QUESTION_TEXT + " text, "
                + TABLE_QUESTION_QUIZ_ID + " text, "
                + " FOREIGN KEY(" + TABLE_QUESTION_QUIZ_ID + ") "
                + " REFERENCES " + TABLE_QUIZ + "(" + TABLE_QUIZ_ID + ")"
                + ")"
        );

        // Создание таблицы вариантов ответов. Внешний ключ указывает на таблицу вопросов.
        sqLiteDatabase.execSQL("create table " + TABLE_OPTIONS + "("
                + TABLE_OPTION_ID + " integer primary key, "
                + TABLE_OPTION_TEXT + " text, "
                + TABLE_OPTION_CORRECT + " integer, "
                + TABLE_OPTION_QUESTION_ID + " text, "
                + " FOREIGN KEY(" + TABLE_OPTION_QUESTION_ID + ") "
                + " REFERENCES " + TABLE_QUESTIONS + "(" + TABLE_QUESTION_ID + ")"
                + ")"
        );

        // Первичное заполнение таблицы тестов
        ContentValues cv = new ContentValues();
        for (int i = 0; i < tests.length; i++) {
            cv.put(TABLE_QUIZ_NAME, tests[i]);
            sqLiteDatabase.insert(TABLE_QUIZ, null, cv);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("drop table if exists " + TABLE_QUIZ);
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_QUESTIONS);
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_OPTIONS);

        onCreate(sqLiteDatabase);
    }
}
