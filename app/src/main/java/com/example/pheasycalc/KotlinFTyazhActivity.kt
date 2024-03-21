package com.example.pheasycalc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class KotlinFTyazhActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_f_tyazh)

        // Отображение единиц измерения в Spinner
        val spinner = findViewById<Spinner>(R.id.spinner21)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.spinner_kg,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Обработчик события для кнопки "Далее"
        val nextButton = findViewById<Button>(R.id.button7)
        nextButton.setOnClickListener {
            // Выполнение расчетов и переход к следующей активности
            calculateAndNavigate()
        }
    }

    private fun calculateAndNavigate() {
        // Получение данных из EditText
        val editTextNumber21 = findViewById<EditText>(R.id.editTextNumber21).text.toString().toDouble()
        val editTextNumber22 = findViewById<EditText>(R.id.editTextNumber22).text.toString().toDouble()

        // Получение выбранного элемента из Spinner
        val spinner21 = findViewById<Spinner>(R.id.spinner21)
        val unit = spinner21.selectedItem.toString()

        // Выполнение расчетов в соответствии с выбранными значениями
        val multiplier = getMultiplier(unit)

        // Выполнение расчетов
        val calculatedResult = editTextNumber21 * multiplier * editTextNumber22

        // Переход к следующей активности и передача результата
        val intent = Intent(this, activity_kotlin_f_tyazh_2::class.java)
        intent.putExtra("result", calculatedResult)
        startActivity(intent)
    }

    // Метод для получения множителя для единиц измерения
    private fun getMultiplier(unit: String): Double {
        return when (unit) {
            "кг" -> 1.0
            "милиграмм" -> 1000000.0
            "грамм" -> 1000.0
            "тонна" -> 0.001
            else -> 1.0
        }
    }
}
