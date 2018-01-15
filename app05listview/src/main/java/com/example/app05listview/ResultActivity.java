package com.example.app05listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.app05listview.data.QuizData;
import com.example.app05listview.data.ResultData;

public class ResultActivity extends AppCompatActivity {

    // Текстовое поле с результатом
    TextView resultText;

    // Текстовое поле с наименованием теста
    TextView quizName;

    Button buttonStart;
    Button buttonQuizAgain;
    Button buttonExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Поле наименование
        quizName = (TextView) findViewById(R.id.test_name);
        quizName.setText(ResultData.getQuizName());

        // Инициализация текстового поля с результатом
        resultText = (TextView) findViewById(R.id.score_text_view);
        resultText.setText(String.valueOf(ResultData.getScore()));

        // Инициализация кнопок
        buttonStart = (Button) findViewById(R.id.button_quiz_choose);
        buttonQuizAgain = (Button) findViewById(R.id.button_test_again);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this,MainActivity.class));
            }
        });

        buttonQuizAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, QuestionActivity.class);

                intent.putExtra("quiz_name","Java");

                startActivity(intent);
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
