package com.example.maklerapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //текущая локаль
        val currentLocale = resources.configuration.locales[0].language

        val login: EditText = findViewById(R.id.login)
        val password: EditText = findViewById(R.id.password)

        val enterButton: Button = findViewById(R.id.enterbutton)

        enterButton.setOnClickListener {
            val txtLogin = login.text.toString().trim()
            val txtPass = password.text.toString().trim()

            if (txtLogin == "12345" && txtPass == "qwerty") {
                val intent = Intent(this, SaleBuyActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            } else {
                Toast.makeText(this, "Пользователь не найден", Toast.LENGTH_SHORT).show()
            }

        }

        // Установка локали
        fun setLocale(languageCode: String) {
            val currentLocale = resources.configuration.locales[0].language
            if (currentLocale == languageCode) {
                // Если локаль уже установлена, ничего не делаем
                return
            }

            val locale = Locale(languageCode)
            Locale.setDefault(locale)

            val config = resources.configuration
            config.setLocale(locale)

            // Применяем изменения
            resources.updateConfiguration(config, resources.displayMetrics)

            // Перезапускаем Activity, чтобы обновить интерфейс
            recreate()
        }

        // Группа кнопок локалей
        val radioGroup: RadioGroup = findViewById(R.id.radiogr)

        // Установить выбранную радиокнопку
        fun setCheckedRadioButton(radioGroup: RadioGroup, languageCode: String) {
            val radioButtonId = when (languageCode) {
                "kk" -> R.id.kz // Казахский
                "ru" -> R.id.ru // Русский
                "en" -> R.id.en // Английский
                else -> R.id.en // По умолчанию английский
            }
            radioGroup.check(radioButtonId)
        }

        // Функция перекликивания меню
        fun setupMenuButtons() {
            radioGroup.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.kz -> setLocale("kk") // Казахский
                    R.id.ru -> setLocale("ru") // Русский
                    R.id.en -> setLocale("en") // Английский
                }
            }
        }

        setCheckedRadioButton(radioGroup, currentLocale)
        setupMenuButtons()

    }
}