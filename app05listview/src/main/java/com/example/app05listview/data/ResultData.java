package com.example.app05listview.data;

import android.util.Log;

import com.example.app05listview.model.Option;
import com.example.app05listview.model.Question;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс для регистрации результатов
 */

public class ResultData {

    private static String quizName;

    private Map<Question, Option> userResults;

    private static int score;

    public ResultData(String quizNam){

        quizName = quizNam;

        userResults = new HashMap<>();
    }

    // Запись ответов на вопросы
    public void setAnswer(Question question, Option option){
        userResults.put(question,option);
    }

    // Получение результата
    public int getResult(){

        score = 0;

        Log.d("ResultData", "Всего ответов: " + this.userResults.size());

        for(Map.Entry<Question,Option> result: userResults.entrySet()){
            Log.d("ResultData", result.getKey().getText() + " user answer is: " + result.getValue().getText() + " - " + result.getValue().isCorrect());
            if(result.getValue().isCorrect()){
                score++;
            }
        }

        return score;
    }

    public static int getScore(){
        return score;
    }

    public static String getQuizName() {
        return quizName;
    }
}
