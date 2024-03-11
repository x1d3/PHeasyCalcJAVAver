package com.example.pheasycalc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Aactivity1 extends AppCompatActivity {

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

                // Вычисления с учетом выбранных значений в спиннерах
                double result = calculateResult(value1, value2, value3, unit1, unit2, timeUnit);

                // Передача результата в следующую активность
                Intent intent = new Intent(Aactivity1.this, Aactivity2.class);
                intent.putExtra("result", result);
                startActivity(intent);
            }
        });
    }

    private double calculateResult(double value1, double value2, double value3, String unit1, String unit2, String timeUnit) {
        // Выполнение вычислений с учетом выбранных значений в спиннерах
        double multiplier1 = getMultiplier(unit1);
        double multiplier2 = getMultiplier(unit2);
        double multiplier3 = getTimeMultiplier(timeUnit);

        // Вычисление результата
        double result = value1 * multiplier1 * value2 * multiplier2 * value3 * multiplier3;

        return result;
    }

    private double getMultiplier(String unit) {
        // Получение множителя в зависимости от выбранного значения в спиннере
        switch (unit) {
            case "пико":
                return 1e-12;
            case "нано":
                return 1e-9;
            case "микро":
                return 1e-6;
            case "милли":
                return 1e-3;
            case "кило":
                return 1e3;
            case "мега":
                return 1e6;
            case "гига":
                return 1e9;
            case "тера":
                return 1e12;
            default:
                return 1; // Для значения "none"
        }
    }

    private double getTimeMultiplier(String timeUnit) {
        // Получение множителя для типа времени
        switch (timeUnit) {
            case "минут":
                return 60;
            case "часов":
                return 3600;
            case "миллисекунд":
                return 0.001;
            default:
                return 1; // Для "секунд"
        }
    }
}
