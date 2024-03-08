package com.example.pheasycalc;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Q_activity_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qactivity1);

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получение введенных значений
                EditText editTextNumber2 = findViewById(R.id.editTextNumber2);
                EditText editTextNumber21 = findViewById(R.id.editTextNumber21);
                EditText editTextNumber22 = findViewById(R.id.editTextNumber22);

                double I = Double.parseDouble(editTextNumber2.getText().toString());
                double R = Double.parseDouble(editTextNumber21.getText().toString());
                double t = Double.parseDouble(editTextNumber22.getText().toString());

                // Расчет Q
                double Q = Math.pow(I, 2) * R * t;

                // Переход к Q_activity_2 и передача результата
                Intent intent = new Intent(Q_activity_1.this, Q_activity_2.class);
                intent.putExtra("result", Q);
                startActivity(intent);
            }
        });
    }
}
