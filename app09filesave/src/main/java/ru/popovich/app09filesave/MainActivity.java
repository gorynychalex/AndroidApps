package ru.popovich.app09filesave;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * File save
 * https://developer.android.com/training/basics/data-storage/files.html?hl=ru
 *
 * Дополнительно:
 * http://startandroid.ru/ru/uroki/vse-uroki-spiskom/138-urok-75-hranenie-dannyh-rabota-s-fajlami.html
 * https://metanit.com/java/android/13.1.php
 */

public class MainActivity extends AppCompatActivity {

    //ОБЪЯВЛЕНИЕ И ИНИЦИАЛИЗАЦИЯ ИМЕНИ ФАЙЛА
    public static final String FILENAME = "file1";

    File file;
    FileOutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity","context.getFileDir(): " + this.getFilesDir());

        // Создание объекта файла
        file = new File(this.getFilesDir(), FILENAME);

        if(file.exists()) {
            Log.d("MainActivity", "FILE EXIST! getAbsolutefile(): " + file.getAbsoluteFile());

        }
        else {
            Log.d("MainActivity", "FILE IS NOT EXIST! getAbsolutefile(): " + file.getAbsoluteFile());
        }

        // ЗАПИСЬ ДАННЫХ
        try {
            // Создание потока вывода
            outputStream = openFileOutput(FILENAME, Context.MODE_APPEND);

            // Инициализация форматированного буферризованного объекта записи
            PrintWriter printWriter = new PrintWriter(outputStream);

            // Создание JSON объекта
            JSONObject jsonObject = new JSONObject();

            // Добавление данных в виде JSON
            jsonObject.put("first","First field");
            jsonObject.put("second","Second field");

            // Запись данных в поток и его закрытие
//            printWriter.write(jsonObject.toString());
//            printWriter.close();

            // Запись данных в поток и его закрытие
            outputStream.write(jsonObject.toString().getBytes());

            // Закрытие потока вывода
            outputStream.close();

        } catch (Exception e){
            e.printStackTrace();
        }


        // ЧТЕНИЕ ДАННЫХ
        BufferedReader bufferedReader=null;
        JsonReader jsonReader = null;

        try {
            // Создание буфферизованного форматированного потока чтения из файла
            bufferedReader = new BufferedReader(new FileReader(file));

            // Объект JSON чтения
            jsonReader = new JsonReader(bufferedReader);
            jsonReader.beginObject();

            // Построчное чтение из файла
            while (jsonReader.hasNext()){
                Log.d("MainActivity",jsonReader.nextName() + " : " + jsonReader.nextString());
            };

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("MainActivity", "FileNotFoundException");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("MainActivity", "IOException");
        } finally {
            try {
                jsonReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
