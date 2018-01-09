package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 28.12.2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "mydatabase";
    private static final int DB_VERSION = 1;
    private static final String TABLE_MAIN = "questions";
    private static final String TABLE_MAIN_ID = "id";
    private static final String TABLE_MAIN_TEXT = "question_text";
    private static final String TABLE_MAIN_OPTIONS = "questions_options";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_MAIN + "("
                + TABLE_MAIN_ID + " integer primary key, "
                + TABLE_MAIN_TEXT + " text, "
                + TABLE_MAIN_OPTIONS + " text " + ")"
        );
//        "create table questions (id integer primary key, question_text text, question_options text"
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
