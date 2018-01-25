package ru.popovich.app09filesave;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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

    public static final String TAG = "MainActivity";

    //ОБЪЯВЛЕНИЕ И ИНИЦИАЛИЗАЦИЯ ИМЕНИ ФАЙЛА
    public static final String FILENAME = "file.txt";

    File file;
    FileOutputStream outputStream;
    BufferedWriter bufferedWriter;
    FileWriter fileWriter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"context.getFileDir(): " + this.getFilesDir());

        Log.d(TAG,"Environment.getExternalStorageDirectory(): " + Environment.getExternalStorageDirectory());
        Log.d(TAG,"Environment.getExternalStorageState(): " + Environment.getExternalStorageState());
        Log.d(TAG,"Environment.DIRECTORY_DOWNLOADS: " + Environment.DIRECTORY_DOCUMENTS);

        // Проверка наличия стандартной директории
        File dir = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DOCUMENTS);
        Log.d(TAG,"Environment.DIRECTORY_DOCUMENTS is Exist: " + dir.exists());
        if(!dir.exists()) {
            dir.mkdir();
            Log.d(TAG, "Environment.DIRECTORY_DOCUMENTS is Exist: " + dir.exists());
        }

        // Создание объекта файла
        file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS.toLowerCase()), FILENAME);

        if(file.exists()) {
            Log.d(TAG, "FILE EXIST! getAbsolutefile(): " + String.valueOf(file.getAbsoluteFile()));
        }
        else {
            Log.d(TAG, "FILE IS NOT EXIST! getAbsolutefile(): " + String.valueOf(file.getAbsoluteFile()));
        }


        // ЗАПИСЬ ДАННЫХ
        try {
            // Создание потока вывода
            bufferedWriter = new BufferedWriter(new FileWriter(file,true));
//            outputStream = openFileOutput(String.valueOf(file.getAbsoluteFile()), Context.MODE_APPEND);
//            fileWriter = new FileWriter(file.getAbsoluteFile());

            // Инициализация форматированного буферризованного объекта записи
//            PrintWriter printWriter = new PrintWriter(outputStream);

            // Создание JSON объекта и добавление данных
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("first1","First field1");
            jsonObject.put("second1","Second field1");

            // Запись данных в поток
            bufferedWriter.write(jsonObject.toString());
//            printWriter.write(jsonObject.toString());
//            outputStream.write(jsonObject.toString().getBytes());
//            fileWriter.write(jsonObject.toString());

//            fileWriter.flush();

            Log.d(TAG, "File has just write!");

        } catch (FileNotFoundException e){
            Log.d(TAG, "FileNotFoundException");
        } catch (Exception e){
            e.printStackTrace();
            Log.d(TAG, "Exception from file save");
        } finally {
            // Закрытие потока вывода
            try {
                bufferedWriter.close();
//                fileWriter.close();
//                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
                Log.d(TAG,"Read:" + jsonReader.nextName() + " : " + jsonReader.nextString());
            };

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG, "FileNotFoundException");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "IOException");
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
