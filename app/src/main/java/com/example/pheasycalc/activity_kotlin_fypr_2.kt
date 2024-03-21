package com.example.pheasycalc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class activity_kotlin_fypr_2: AppCompatActivity() {

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

        // Отображение единиц измерения в Spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.spinner_items,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                // Получение множителя в зависимости от выбора в Spinner
                currentMultiplier = getMultiplier(position)
                // Пересчет результата с новым множителем
                val updatedResult = result * currentMultiplier
                // Обновление результата в EditText
                editTextNumber.setText(updatedResult.toString())
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Обработка, если ничего не выбрано
            }
        }

        // Обработчик события для кнопки button9
        val button9 = findViewById<Button>(R.id.button9)
        button9.setOnClickListener {
            // Создание Intent для перехода к MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // Запуск MainActivity
            startActivity(intent)
        }
    }

    // Метод для получения множителя в зависимости от выбора в Spinner
    private fun getMultiplier(position: Int): Double {
        return when (position) {
            0 -> 1.0 // none
            1 -> 1e12 // pico
            2 -> 1e9 // nano
            3 -> 1e6 // micro
            4 -> 1e3 // milli
            5 -> 1e-3 // kilo
            6 -> 1e-6 // mega
            7 -> 1e-9 // giga
            else -> 1e-12 // tera
        }
    }
}
