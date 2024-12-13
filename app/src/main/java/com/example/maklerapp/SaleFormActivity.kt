package com.example.maklerapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SaleFormActivity: AppCompatActivity() {
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
    }
}