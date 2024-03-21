package com.example.pheasycalc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class activity_kotlin_fypr_2 : AppCompatActivity() {

    private var result = 0.0
    private var currentMultiplier = 1.0 // Начальный множитель

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_fypr2)

        // Получение переданных данных из Intent
        result = intent.getDoubleExtra("result", 0.0)

        // Отображение результата в EditText
        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        editTextNumber.setText(result.toString())

        // Обработчик события для кнопки button9
        val button9 = findViewById<Button>(R.id.button9)
        button9.setOnClickListener {
            // Создание Intent для перехода к MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // Запуск MainActivity
            startActivity(intent)
        }
    }
}
