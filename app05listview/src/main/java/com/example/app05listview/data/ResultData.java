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

    // На всякий случай сохраняем наименование теста
    private static String quizName;

    // Объявление переменной для хранения пользовательских результатов
    private Map<Question, Option> userResults;

    // Переменная для хранения баллов (оценки)
    private static int score;

    // Конструктор для первичной инициализации данных для результатов
    public ResultData(String quizNam){

        // Сохранение наименования теста
        ResultData.quizName = quizNam;

        // Инициализация карты результатов
        userResults = new HashMap<>();
    }

    // Запись ответов на вопросы
    public void setAnswer(Question question, Option option){

        userResults.put(question,option);

    }

    // Получение результата. Примитивная реализация.
    // Алгоритм: сравнивается правильность ответа и ответа пользователя.
    //           Если правильный выбор - начисляется 1
    public int getResult(){

        // Очистка от предыдущих оценок
        score = 0;

        Log.d("ResultData", "Всего ответов: " + this.userResults.size());

        // Используем простой перебор сохраненных данных
        for(Map.Entry<Question,Option> result: userResults.entrySet()){
            Log.d("ResultData", result.getKey().getText() + " user answer is: " + result.getValue().getText() + " - " + result.getValue().isCorrect());
            if(result.getValue().isCorrect()){
                score++;
            }
        }

        return score;
    }

    // Метод получения оценки. Вызывается только в результирующей активности
    public static int getScore(){
        return score;
    }


    public static String getQuizName() {
        return quizName;
    }
}
