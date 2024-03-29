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

public class Iactivity2 extends AppCompatActivity {

    private double result = 0;
    private double currentMultiplier = 1; // Начальный множитель

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iactivity2);

        // Получение переданных данных из Intent
        Intent intent = getIntent();
        result = intent.getDoubleExtra("result", 0);

        // Отображение результата в EditText
        EditText editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber.setText(String.valueOf(result));

        // Отображение единиц измерения в Spinner
        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Получение множителя в зависимости от выбора в Spinner
                currentMultiplier = getMultiplier(position);
                // Пересчет результата с новым множителем
                double updatedResult = result * currentMultiplier;
                // Обновление результата в EditText
                editTextNumber.setText(String.valueOf(updatedResult));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Обработка, если ничего не выбрано
            }
        });

        // Обработчик события для кнопки button9
        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создание Intent для перехода к MainActivity
                Intent intent = new Intent(Iactivity2.this, MainActivity.class);
                // Запуск MainActivity
                startActivity(intent);
            }
        });
    }

    // Метод для получения множителя в зависимости от выбора в Spinner
    private double getMultiplier(int position) {
        switch (position) {
            case 0: // none
                return 1;
            case 1: // pico
                return 1e12;
            case 2: // nano
                return 1e9;
            case 3: // micro
                return 1e6;
            case 4: // milli
                return 1e3;
            case 5: // kilo
                return 1e-3;
            case 6: // mega
                return 1e-6;
            case 7: // giga
                return 1e-9;
            default: // tera
                return 1e-12;
        }
    }
}

