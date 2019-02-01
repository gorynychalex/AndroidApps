package ru.popovich.app021calculate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Simple project
 * Calculate: last digit is odd
 */

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button buttonCalc;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input_value1);
        buttonCalc = findViewById(R.id.button);
        result = findViewById(R.id.result_view);

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = input.getText().toString();
                int x = s.isEmpty()?0:Integer.parseInt(s);
                result.setText(String.valueOf(x - x%2 + 2));
            }
        });

        buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(input.getText().toString());

                result.setText(String.valueOf(x%10));
            }
        });

    }
}
