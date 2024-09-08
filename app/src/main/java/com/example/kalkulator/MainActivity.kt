package com.example.kalkulator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val input1 = findViewById<EditText>(R.id.edt_input1)
        val input2 = findViewById<EditText>(R.id.edt_input2)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val buttonHitung = findViewById<Button>(R.id.btn_hitung)

        buttonHitung.setOnClickListener {
            val angka1 = input1.text.toString().toDoubleOrNull()
            val angka2 = input2.text.toString().toDoubleOrNull()

            if(angka1 != null && angka2 != null) {
                val operator = when (radioGroup.checkedRadioButtonId) {
                    R.id.btn_tambah -> "+"
                    R.id.btn_kurang -> "-"
                    R.id.btn_kali -> "*"
                    R.id.btn_bagi -> "/"
                    else -> ""
                }

                val result = when (operator) {
                    "+" -> angka1 + angka2
                    "-" -> angka1 - angka2
                    "*" -> angka1 * angka2
                    "/" -> if(angka2 != 0.0) angka1/angka2 else "Error"
                    else -> "Operator bermasalah"
                }

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("result", result.toString())
                startActivity(intent)
            }
        }



//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}