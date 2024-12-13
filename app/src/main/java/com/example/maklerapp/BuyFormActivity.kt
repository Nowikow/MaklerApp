package com.example.maklerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions

class BuyFormActivity: AppCompatActivity() {

    private val scanLauncner = registerForActivityResult(
        ScanContract()) { result ->
        if (result.contents == null) {

        } else {
            val intent = Intent(this, PayListActivity::class.java)
            intent.putExtra("code", result.contents.toString())
            startActivity(intent)
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
    }

    private fun scan() {
        scanLauncner.launch(ScanOptions())
    }
}