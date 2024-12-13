package com.example.maklerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SaleBuyActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sale_buy)

        val backButton: TextView = findViewById(R.id.titeltext)

        val sell: Button = findViewById(R.id.button)
        val buy: Button = findViewById(R.id.button2)

        backButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        sell.setOnClickListener{
            val intent = Intent(this, HouseListActivity::class.java)
            startActivity(intent)
        }

        buy.setOnClickListener{
            val intent = Intent(this, BuyFormActivity::class.java)
            startActivity(intent)
        }
    }
}