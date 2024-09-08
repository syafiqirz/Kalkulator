package com.example.kalkulator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        val teksHasil = findViewById<TextView>(R.id.tv_hasil)
        val hasil = intent.getStringExtra("result")
        teksHasil.text = "Hasil: $hasil"
    }
}