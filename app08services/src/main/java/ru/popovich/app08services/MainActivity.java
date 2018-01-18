package ru.popovich.app08services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // инициализируем текстовое поле
        textView = findViewById(R.id.temp_txt);

        registerReceiver(receiver, new IntentFilter(GisService.CHANNEL));
        Intent intent = new Intent(this, GisService.class);
        startService(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent(this, GisService.class);
        stopService(intent);
    }

    protected BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                JSONObject jsonObject = new JSONObject(intent.getStringExtra(GisService.INFO));
                Log.d("MainActivity", "Overall names: " + jsonObject.names());
                JSONArray gisArray = jsonObject.getJSONArray("gis");

                List<String> fieldsOfArray = new ArrayList<>();
                if(jsonObject.length() != 0){
                    for(String field: gisArray.getJSONObject(0).names().toString().split(":")){
                        fieldsOfArray.add(field);
                        Log.d("MainActivity","field: " + field);
                    }
                }

                textView.setText(gisArray.toString());
                Log.d("MainActivity", String.valueOf(gisArray.length()));
            } catch (JSONException e) {
                Toast.makeText(MainActivity.this,"Неверный формат JSON", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    };
}
