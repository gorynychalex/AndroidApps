package com.example.app05listview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.app05listview.data.QuizData;
import com.example.app05listview.data.ResultData;
import com.example.app05listview.model.Option;

/**
 * Активность для задания вопроса
 */

public class QuestionActivity extends AppCompatActivity{

    // Объявление переменных Views
    static TextView textViewTestName;
    static TextView textViewQuestionText;
    static TextView textViewQuestionNum;
    static TextView textViewQuestionNums;

    // Переменная для входного интента
    Intent inputIntent;

    // Наименование теста
    String testName;

    // Количество вопросов в тесте
    int question_nums;

    // Номер вопроса в тесте
    int question_num;

    // Варианты ответов
    static String[] options;

    // Переменная для адаптера
    static ArrayAdapter arrayAdapterOptions;

    // Переменная для списка вопросов
    static ListView listViewOptions;

    // Переменная для хранения выбранного пункта варианта ответа
    static int position_option;

    // Переменные для кнопок
    Button buttonNext;
    Button buttonPrev;
    Button buttonFinish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // Инициализация текстового поля
        textViewTestName = (TextView) findViewById(R.id.test_name);

        // Получение входного "намерения"
        inputIntent = getIntent();

        // Получение переменной position по ключу
        final int position = inputIntent.getIntExtra("position",0);
        testName = inputIntent.getStringExtra("test");

        // Создание нового объекта результат
        final ResultData resultData = new ResultData(QuizData.getQuizs().get(position).getName());

        Log.d("QuestionActivity", ResultData.getQuizName());

        Log.d("QuestionActivity", String.valueOf(position));

        // Отображение наименования теста
        textViewTestName.setText(QuizData.getQuizs().get(position).getName());

        // Количество вопросов в тесте
        question_nums = QuizData.getQuizs().get(position).getQuestion().size();

        // Вывод в верхний правый угол активности количества вопросов
        textViewQuestionNums = (TextView) findViewById(R.id.text_view_question_nums);
        textViewQuestionNums.setText(String.valueOf(question_nums));

        // Инициализация текстового поля для вопроса
        textViewQuestionText = (TextView) findViewById(R.id.question_text);
        textViewQuestionNum = (TextView) findViewById(R.id.question_num);

        // Инициализация списка и заполнение данными из адаптера
        listViewOptions = (ListView) findViewById(R.id.list_view_questions);

        // Метод отображения вопроса
        showQuestion(this,position,question_num);

        //Кнопки управления
        buttonNext = (Button) findViewById(R.id.button_question_next);
        buttonPrev = (Button) findViewById(R.id.button_question_prev);
        buttonFinish = (Button) findViewById(R.id.button_quiestion_finish);

        // Слушатель нажатий на кнопку "Следующий" вопрос и метод
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Сохранение результата выбора
                resultData.setAnswer(QuizData.getQuizs().get(position).getQuestion().get(question_num),
                        QuizData.getQuizs().get(position).getQuestion().get(question_num).getOptions().get(position_option));

                if(question_num < QuizData.getQuizs().get(position).getQuestion().size()) {

                    question_num = (question_num + 1) % question_nums;

                    textViewQuestionNum.setText(String.valueOf(question_num + 1));

                    showQuestion(QuestionActivity.this,position,question_num);
                }

            }
        });

        // Слушатель нажатий на кнопку "Предыдущий" вопрос и метод
        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Сохранение результата
                resultData.setAnswer(QuizData.getQuizs().get(position).getQuestion().get(question_num),
                        QuizData.getQuizs().get(position).getQuestion().get(question_num).getOptions().get(position_option));

                if(question_num > 0) {

                    question_num = (question_num - 1) % question_nums;

                    textViewQuestionNum.setText(String.valueOf(question_num + 1));

                    showQuestion(QuestionActivity.this,position,question_num);
                }
            }
        });

        // Слушатель нажатий на кнопку "Закончить" вопрос и метод
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Сохранение результата
                resultData.setAnswer(QuizData.getQuizs().get(position).getQuestion().get(question_num),
                        QuizData.getQuizs().get(position).getQuestion().get(question_num).getOptions().get(position_option));

                resultData.getResult();

                // Вызов активности с результатом
                Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);

                startActivity(intent);
            }
        });

    }

    // Метод для перезаполнения данными формы
    public static void showQuestion(Context context, int quiz, int question_num){

        // Отображение вопроса
        textViewQuestionText.setText(QuizData.getQuizs().get(quiz).getQuestion().get(question_num).getText());
        textViewQuestionNum.setText(String.valueOf(question_num+1));

        // Подготовка вариантов ответов
        int i=0;
        options = new String[QuizData.getQuizs().get(quiz).getQuestion().get(question_num).getOptions().size()];
        for(Option option: QuizData.getQuizs().get(quiz).getQuestion().get(question_num).getOptions()){
            options[i++] = option.getText();
        }

        // Адаптер для списка вариантов ответов
        arrayAdapterOptions = new ArrayAdapter(context, android.R.layout.select_dialog_singlechoice,
                options);

        // Обновление адаптера
        listViewOptions.setAdapter(arrayAdapterOptions);

        listViewOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                position_option = position;
            }
        });
    }
}
