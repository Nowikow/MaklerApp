package com.example.maklerapp

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class SaleFormActivity: AppCompatActivity() {
    private lateinit var textViewEnglish: TextView
    private lateinit var textViewRussian: TextView
    private lateinit var textViewKazakh: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sale_form)

        val backButton: TextView = findViewById(R.id.titeltext)
        val codeText: TextView = findViewById(R.id.code)

        codeText.text = intent.getStringExtra("code").toString()

        val qrImg: ImageView = findViewById(R.id.qr)
        if (codeText.text == "5436987") {
            qrImg.setImageResource(R.drawable.qrcode1)
        } else if (codeText.text == "7654123") {
            qrImg.setImageResource(R.drawable.qrcode2)
        } else  if (codeText.text == "1238439") {
            qrImg.setImageResource(R.drawable.qrcode3)
        }

        backButton.setOnClickListener{
            val intent = Intent(this, HouseListActivity::class.java)
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