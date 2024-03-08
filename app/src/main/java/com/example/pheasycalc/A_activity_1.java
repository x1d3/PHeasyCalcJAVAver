package com.example.pheasycalc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class A_activity_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aactivity1);

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получение значений из EditText
                EditText editTextNumber2 = findViewById(R.id.editTextNumber2);
                EditText editTextNumber21 = findViewById(R.id.editTextNumber21);
                EditText editTextNumber22 = findViewById(R.id.editTextNumber22);
                double value1 = Double.parseDouble(editTextNumber2.getText().toString());
                double value2 = Double.parseDouble(editTextNumber21.getText().toString());
                double value3 = Double.parseDouble(editTextNumber22.getText().toString());

                // Получение выбранных элементов из Spinner
                Spinner spinner23 = findViewById(R.id.spinner23);
                String unit1 = spinner23.getSelectedItem().toString();
                Spinner spinner21 = findViewById(R.id.spinner21);
                String unit2 = spinner21.getSelectedItem().toString();
                Spinner spinner2 = findViewById(R.id.spinner2);
                String timeUnit = spinner2.getSelectedItem().toString();

                // Вычисления
                double result = calculateResult(value1, value2, value3, unit1, unit2, timeUnit);

                // Передача результата в следующую активность
                Intent intent = new Intent(A_activity_1.this, A_activity_2.class);
                intent.putExtra("result", result);
                startActivity(intent);
            }
        });
    }

    private double calculateResult(double value1, double value2, double value3, String unit1, String unit2, String timeUnit) {
        // Выполнение вычислений
        // Реализуйте здесь необходимые вычисления в соответствии с вашей формулой
        // Пример:
        double result = value1 * value2 * value3;
        // Дополните этот метод в соответствии с вашей логикой
        return result;
    }
}
