package com.example.formativa1_andresjaimes;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    Button calculate;
    EditText input1, input2;
    Spinner idSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);


        idSpinner = findViewById(R.id.idSpinner);
        calculate = findViewById(R.id.calculate);
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.operations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idSpinner.setAdapter(adapter);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = input1.getText().toString();
                String text2 = input2.getText().toString();

                if (text1.equals("") || text2.equals("")) {
                    Toast.makeText(Calculator.this, "Los datos están vacíos", Toast.LENGTH_LONG).show();
                    return;
                }

                double num1 = Double.parseDouble(text1);
                double num2 = Double.parseDouble(text2);
                String selectedOperation = idSpinner.getSelectedItem().toString();
                double result = 0;

                switch (selectedOperation) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            Toast.makeText(Calculator.this, "División por cero no permitida", Toast.LENGTH_LONG).show();
                            return;
                        }
                        break;

                }


                Toast.makeText(Calculator.this, "El resultado es: " + result, Toast.LENGTH_LONG).show();
            }
        });

    }

}
