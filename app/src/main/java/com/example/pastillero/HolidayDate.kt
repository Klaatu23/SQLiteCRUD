package com.example.pastillero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class HolidayDate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_holiday_date)

        val bundle = intent.extras
        val id = bundle?.getInt("id")
        //Declaración de variables
        val motivo = findViewById<EditText>(R.id.edt1)
        val fecha = findViewById<EditText>(R.id.edate)

        motivo.hint = "Nombre del motivo"


    }
}