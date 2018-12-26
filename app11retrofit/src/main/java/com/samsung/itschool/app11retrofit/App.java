package com.samsung.itschool.app11retrofit;

import android.app.Application;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by gorynych on 08.02.18.
 */

public class App extends Application {

    //URL API
//    private static final String url = "http://192.168.74.109:8080/";
    private static final String url = "http://10.168.0.115:8080/";

    private Retrofit retrofit;

    private static QuizAPI quizAPI;

    @Override
    public void onCreate() {
        super.onCreate();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        quizAPI = retrofit.create(QuizAPI.class);
    }

    public static QuizAPI getQuizAPI() { return quizAPI; }
}
