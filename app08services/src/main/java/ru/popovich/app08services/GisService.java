package ru.popovich.app08services;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import androidx.annotation.Nullable;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by gorynych on 18.01.18.
 */

public class GisService extends Service {


    public static final String CHANNEL = "GIS SERVICE";
    public static final String INFO = "INFO";
    public static final String URLMETEO = "http://icomms.ru/inf/meteo.php?tid=12";


    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(this,"Service maked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        GisAsyncTask gisAsynTask = new GisAsyncTask();
        gisAsynTask.execute();

        return START_NOT_STICKY;

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private class GisAsyncTask extends AsyncTask<Void,Void,String>{

        @Override
        protected String doInBackground(Void... voids) {
            // Переменная, значение которой нужно будет вернуть
            String result;

            //Переменная для загрузки данных
            URL url;

            BufferedReader bufferedReader;

            try{
                url = new URL(URLMETEO);

                url.getContent();

                bufferedReader = new BufferedReader(new InputStreamReader((InputStream) url.getContent()));

                result = "{\"gis\": " + bufferedReader.readLine() + "}";

            } catch (Exception e){
                result = e.toString();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            // Интент для отправки ответа
            Intent intent = new Intent(CHANNEL);
            intent.putExtra(INFO, s);
            // Рассылка данных через broadcast
            sendBroadcast(intent);
        }
    }
}
