package com.samsung.itschool.app11retrofit;

import com.samsung.itschool.app11retrofit.model.Question;
import com.samsung.itschool.app11retrofit.model.Quiz;
import com.samsung.itschool.app11retrofit.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * API for Quiz: Questions and Options
 */

public interface QuizAPI {

    @GET("rest/questrs/1")
    Call<Quiz> getQuiz();

    @GET("rest/questrs/quiz/questions")
    Call<List<Question>> getQuestions();

    @GET("rest/questrs/quiz/{id}")
    Call<Question> getQuestionById(@Path("id") int id);

    @GET("rest/questrs/user/{id}")
    Call<User> getUserById(@Path("id") int id);

    @GET("rest/questrs/users")
    Call<List<User>> getUsers();

}
