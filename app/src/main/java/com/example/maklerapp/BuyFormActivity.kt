package com.example.maklerapp

import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import java.util.Locale

class BuyFormActivity: AppCompatActivity() {

    private lateinit var textViewEnglish: TextView
    private lateinit var textViewRussian: TextView
    private lateinit var textViewKazakh: TextView

    private val scanLauncner = registerForActivityResult(
        ScanContract()) { result ->
        if (result.contents == null) {

        } else {
            if (result.contents.toString() == "5436987" || result.contents.toString() == "7654123" || result.contents.toString() == "1238439") {
                val intent = Intent(this, PayListActivity::class.java)
                intent.putExtra("code", result.contents.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Код не найден", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buy_form)

        val codeform: EditText = findViewById(R.id.codeform)

        val backButton: TextView = findViewById(R.id.titeltext)
        val codebutton: Button = findViewById(R.id.codebutton)

        val cameraButton: ImageView = findViewById(R.id.camera)


        backButton.setOnClickListener{
            val intent = Intent(this, SaleBuyActivity::class.java)
            startActivity(intent)
        }

        codebutton.setOnClickListener {
            if (codeform.text.toString() == "5436987" || codeform.text.toString() == "7654123" || codeform.text.toString() == "1238439") {
                val intent = Intent(this, PayListActivity::class.java)
                intent.putExtra("code", codeform.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Код не найден", Toast.LENGTH_SHORT).show()
            }
        }

        cameraButton.setOnClickListener{
            scan()
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

    private fun scan() {
        scanLauncner.launch(ScanOptions())
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