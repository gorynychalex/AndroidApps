package com.samsung.itschool.app11retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.samsung.itschool.app11retrofit.model.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity","OnCreate()");

        App.getQuizAPI().getQuestions().enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                Log.d("MainActivity", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {

            }
        });
    }
}
