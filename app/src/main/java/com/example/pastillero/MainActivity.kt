package com.example.pastillero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bundle = intent.extras
        val id = bundle?.getInt("id")
        val user = bundle?.getString("user")

        val texto = findViewById<TextView>(R.id.txt1)
        val btn1 = findViewById<ImageButton>(R.id.imbt1)
        val btn2 = findViewById<ImageButton>(R.id.imbt2)
        val btn3 = findViewById<ImageButton>(R.id.imbt3)
        val btn4 = findViewById<ImageButton>(R.id.imbt4)


        //Muestra el nombre del usuario
        texto.setText(user)

        //activity Gifts
        btn1.setOnClickListener {

            val intent = Intent(this, Gifts::class.java)
            startActivity(intent)

        }
        //activity Holiday Date

        btn3.setOnClickListener {

            val intent = Intent(this, HolidayDate::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }

        btn4.setOnClickListener {
            finish()
        }


    }
}