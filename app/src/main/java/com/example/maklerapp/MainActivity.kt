package com.example.maklerapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
    }
}