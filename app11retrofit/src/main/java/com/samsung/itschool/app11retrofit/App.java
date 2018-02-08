package com.samsung.itschool.app11retrofit;

import android.app.Application;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gorynych on 08.02.18.
 */

public class App extends Application {

    //URL API
    private static final String url = "http://localhost:8080/";

    private Retrofit retrofit;

    private static QuizAPI quizAPI;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        quizAPI = retrofit.create(QuizAPI.class);
    }

    public static QuizAPI getQuizAPI() { return quizAPI; }
}
