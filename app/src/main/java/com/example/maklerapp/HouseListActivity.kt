package com.example.maklerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HouseListActivity: AppCompatActivity() {
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
    }
}