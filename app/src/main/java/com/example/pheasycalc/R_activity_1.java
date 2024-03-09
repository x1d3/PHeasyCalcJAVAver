package com.example.pheasycalc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class R_activity_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ractivity1);

        // Отображение единиц измерения в Spinner
        Spinner spinner = findViewById(R.id.spinner23);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Отображение единиц времени в Spinner
        Spinner spinnerTime = findViewById(R.id.spinner21);

        ArrayAdapter<CharSequence> adapterTime = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapterTime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTime.setAdapter(adapterTime);

        // Обработчик события для кнопки "Далее"
        Button nextButton = findViewById(R.id.button7);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Выполнение расчетов и переход к следующей активности
                calculateAndNavigate();
            }
        });
    }

    private void calculateAndNavigate() {
        // Получение данных из EditText
        EditText editTextNumber2 = findViewById(R.id.editTextNumber2);
        EditText editTextNumber21 = findViewById(R.id.editTextNumber21);

        // Преобразование данных в числа
        double value2 = Double.parseDouble(editTextNumber2.getText().toString());
        double value21 = Double.parseDouble(editTextNumber21.getText().toString());

        // Получение выбранных элементов из Spinner
        Spinner spinner23 = findViewById(R.id.spinner23);
        String unit1 = spinner23.getSelectedItem().toString();
        Spinner spinner21 = findViewById(R.id.spinner21);
        String unit2 = spinner21.getSelectedItem().toString();

        // Выполнение расчетов в соответствии с выбранными значениями
        double multiplier1 = getMultiplier(unit1);
        double multiplier2 = getMultiplier(unit2);

        // Выполнение расчетов
        double calculatedResult = (value2 * multiplier1) / (value21 * multiplier2);

        // Переход к следующей активности и передача результата
        Intent intent = new Intent(R_activity_1.this, R_activity_2.class);
        intent.putExtra("result", calculatedResult);
        startActivity(intent);
    }

    // Метод для получения множителя для единиц измерения
    private double getMultiplier(String unit) {
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
                return 1;
        }
    }
}
