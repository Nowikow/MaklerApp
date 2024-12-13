package com.example.maklerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PayListActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pay_list)

        val code = intent.getStringExtra("code").toString()

        val payAmmount: TextView = findViewById(R.id.payammounttext)
        if (code == "5436987") {
            payAmmount.text = "К оплате: 55.400.000 KZ"
        } else if (code == "7654123") {
            payAmmount.text = "К оплате: 41.490.000 KZ"
        } else {
            payAmmount.text = "К оплате: 35.690.000 KZ"
        }

        val backButton: Button = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            val intent = Intent(this, SaleBuyActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}