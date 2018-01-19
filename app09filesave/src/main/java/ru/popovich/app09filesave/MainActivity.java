package ru.popovich.app09filesave;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * File save
 */

public class MainActivity extends AppCompatActivity {

    String filename = "fileMainActivity";
    FileOutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity","context.getFileDir(): " + this.getFilesDir());

        File file = new File(this.getFilesDir(), filename);

        Log.d("MainActivity","getAbsolutefile(): " + file.getAbsoluteFile());

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            PrintWriter printWriter = new PrintWriter(outputStream);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("first","First field");
            jsonObject.put("second","Second field");
            printWriter.write(jsonObject.toString());
            printWriter.close();

//            outputStream.write("My text first line".getBytes());
//            outputStream.write("Second line".getBytes());

            outputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }


        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            JsonReader jsonReader = new JsonReader(bufferedReader);
            jsonReader.beginObject();

            while (jsonReader.hasNext()){
                Log.d("MainActivity",jsonReader.nextName() + " : " + jsonReader.nextString());
            };
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("MainActivity", "FileNotFoundException");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("MainActivity", "IOException");
        }
    }
}
