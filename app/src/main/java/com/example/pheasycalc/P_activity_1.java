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

public class P_activity_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pactivity1);

        // Отображение единиц измерения в Spinner
        Spinner spinner = findViewById(R.id.spinner23);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Отображение единиц времени в Spinner
        Spinner spinnerTime = findViewById(R.id.spinner21);

        ArrayAdapter<CharSequence> adapterTime = ArrayAdapter.createFromResource(this,
                R.array.spinner_times, android.R.layout.simple_spinner_item);
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

        // Выполнение расчетов
        double calculatedResult = value2 * value21;

        // Переход к следующей активности и передача результата
        Intent intent = new Intent(P_activity_1.this, P_activity_2.class);
        intent.putExtra("result", calculatedResult);
        startActivity(intent);
    }
}
