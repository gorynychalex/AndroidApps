package com.samsung.itschool.app11retrofit;

import com.samsung.itschool.app11retrofit.model.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * API for Quiz: Questions and Options
 */

public interface QuizAPI {

    @GET("rest/questrs/all")
    Call<List<Question>> getQuestions();

    @GET("rest/questrs/{id}")
    Call<Question> getQuestionById(@Path("id") int id);

}
