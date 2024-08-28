package com.example.formativa1_andresjaimes;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button_activity;
    EditText firstEditText, secondEditText;
    TextView signs;
    Random random;
    int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    String[] operators = {"+", "-", "*", "/"};
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        button_activity = findViewById(R.id.button_activity);
        firstEditText = findViewById(R.id.firstEditText);
        secondEditText = findViewById(R.id.secondEditText);
        signs = findViewById(R.id.signs);


        random = new Random();
        handler = new Handler();


        runnable = new Runnable() {
            @Override
            public void run() {
                int randomNum1 = numbers[random.nextInt(numbers.length)];
                int randomNum2 = numbers[random.nextInt(numbers.length)];

                int randomIndex = random.nextInt(operators.length);
                String randomOperator = operators[randomIndex];


                firstEditText.setText(String.valueOf(randomNum1));
                secondEditText.setText(String.valueOf(randomNum2));
                signs.setText(randomOperator);


                handler.postDelayed(this, 2500);
            }
        };


        handler.post(runnable);


        button_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Calculator.class);
                startActivity(i);
            }
        });
    }
}
