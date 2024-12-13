package com.example.maklerapp

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class HouseListActivity: AppCompatActivity() {
    private lateinit var textViewEnglish: TextView
    private lateinit var textViewRussian: TextView
    private lateinit var textViewKazakh: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.house_list)

        val backButton: TextView = findViewById(R.id.titeltext)

        val flat_1: TextView = findViewById(R.id.example1)
        val flat_2: TextView = findViewById(R.id.example2)
        val flat_3: TextView = findViewById(R.id.example3)

        backButton.setOnClickListener{
            val intent = Intent(this, SaleBuyActivity::class.java)
            startActivity(intent)
        }

        flat_1.setOnClickListener{
            val intent = Intent(this, SaleFormActivity::class.java)
            intent.putExtra("code", "5436987")
            startActivity(intent)
        }
        flat_2.setOnClickListener{
            val intent = Intent(this, SaleFormActivity::class.java)
            intent.putExtra("code", "7654123")
            startActivity(intent)
        }
        flat_3.setOnClickListener{
            val intent = Intent(this, SaleFormActivity::class.java)
            intent.putExtra("code", "1238439")
            startActivity(intent)
        }

        // Найдем TextView
        textViewEnglish = findViewById(R.id.en)
        textViewRussian = findViewById(R.id.ru)
        textViewKazakh = findViewById(R.id.kz)

        // Устанавливаем цвет в зависимости от текущей локали
        setCurrentLocaleColor(getCurrentLocale())

        // События нажатия
        textViewEnglish.setOnClickListener {
            setLocale("en")
            updateColors(textViewEnglish)
        }

        textViewRussian.setOnClickListener {
            setLocale("ru")
            updateColors(textViewRussian)
        }

        textViewKazakh.setOnClickListener {
            setLocale("kk")
            updateColors(textViewKazakh)
        }
    }

    // Метод для смены локали
    private fun setLocale(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        resources.updateConfiguration(config, resources.displayMetrics)

        // Перезагрузка активности
        recreate()
    }

    // Получить текущую локаль устройства
    private fun getCurrentLocale(): String {
        return if (resources.configuration.locales.isEmpty) {
            Locale.getDefault().language
        } else {
            resources.configuration.locales[0].language
        }
    }

    // Устанавливаем зеленый цвет активному языку
    private fun setCurrentLocaleColor(locale: String) {
        when (locale) {
            "en" -> updateColors(textViewEnglish)
            "ru" -> updateColors(textViewRussian)
            "kk" -> updateColors(textViewKazakh)
        }
    }

    // Изменение цвета для выбранного языка
    private fun updateColors(selectedTextView: TextView) {
        textViewEnglish.setTextColor(Color.BLACK)
        textViewRussian.setTextColor(Color.BLACK)
        textViewKazakh.setTextColor(Color.BLACK)

        selectedTextView.setTextColor(Color.GREEN)
    }
}