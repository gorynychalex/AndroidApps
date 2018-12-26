package com.samsung.itschool.app11retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.samsung.itschool.app11retrofit.model.Option;
import com.samsung.itschool.app11retrofit.model.Question;
import com.samsung.itschool.app11retrofit.model.Quiz;
import com.samsung.itschool.app11retrofit.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    String resposeString;

    TextView textView;

    List<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textResponse);

        questions = new ArrayList<>();

        App.getQuizAPI().getQuestions().enqueue(new Callback<List<Question>>() {


            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                Log.d(TAG, "onResponse(): " + response.errorBody().toString());
            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {

                Log.d(TAG, "onFailure(): ");

            }
        });

        App.getQuizAPI().getQuiz().enqueue(new Callback<Quiz>() {
            @Override
            public void onResponse(Call<Quiz> call, Response<Quiz> response) {
//                Log.d(TAG, response.toString());
                textView.setText(response.body().getQuestions().get(0).getText());
            }

            @Override
            public void onFailure(Call<Quiz> call, Throwable t) {



            }
        });

//        App.getQuizAPI().getQuestionById(1).enqueue(new Callback<Question>() {
//            @Override
//            public void onResponse(Call<Question> call, Response<Question> response) {
//                textView.setText(response.body().getText());
//            }
//
//            @Override
//            public void onFailure(Call<Question> call, Throwable t) {
//
//            }
//        });

//        App.getQuizAPI().getUsers().enqueue(new Callback<List<User>>() {
//            @Override
//            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
//                Log.d(TAG,response.body().toArray().toString());
//            }
//
//            @Override
//            public void onFailure(Call<List<User>> call, Throwable t) {
//
//            }
//        });
    }
}
