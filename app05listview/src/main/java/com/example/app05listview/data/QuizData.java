package com.example.app05listview.data;

import com.example.app05listview.model.Option;
import com.example.app05listview.model.Question;
import com.example.app05listview.model.Quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 26.12.2017.
 */

public class QuizData {

    private static List<Quiz> quizs;

    public static void setList(){
        quizs = new ArrayList<>();
        List<Question> questions = new ArrayList<>();
        List<Option> options1 = new ArrayList<>();

        options1.add(new Option("присвоить null всем ссылкам на объект",false));
        options1.add(new Option("вызвать Runtime.getRuntime().gc()",false));
        options1.add(new Option("вызвать метод finalize() у объекта",false));
        options1.add(new Option("этого нельзя сделать вручную",true));
        options1.add(new Option("вызвать деструктор у объекта",false));
        questions.add(new Question("Как можно уничтожить объект в Java?",options1));

        quizs.add(new Quiz("Java",questions));
    }

    public static List<Quiz> getQuizs(){
        return quizs;
    }
}
