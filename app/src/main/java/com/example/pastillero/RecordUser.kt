package com.example.pastillero

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RecordUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_user)
        //Declaración de variables
        val usr1 = findViewById<EditText>(R.id.edt1)
        val usr11 = findViewById<EditText>(R.id.edt11)
        val pwd1 = findViewById<EditText>(R.id.edt2)
        val pwd11 = findViewById<EditText>(R.id.edt22)
        val botonRegistrar = findViewById<Button>(R.id.bt2)

        usr1.hint = "Escribe el usuario "
        usr11.hint = "Confirma el usuario"
        pwd1.hint = "Escribe el password "
        pwd11.hint ="Confirma el password "


        //Registro Usuario
        botonRegistrar.setOnClickListener {

            if(usr1.text.toString() == usr11.text.toString() && pwd1.text.toString() == pwd11.text.toString())
            {
                val admin = DataBase(this, "HB", null, 1)
                val db = admin.writableDatabase
                val record = ContentValues()
                record.put("user",usr11.text.toString())
                record.put("password",pwd11.text.toString())
                var id = db.insert("user",null,record)
                db.close()
                if(id > 0) {
                    Toast.makeText(this, "Usuario registrado...", Toast.LENGTH_SHORT).show()
                    finish()
                }else{
                    Toast.makeText(this, "Ha ocurrido algo...", Toast.LENGTH_SHORT).show()
                }

            }
            else
            {
                Toast.makeText(this, "Favor de confirmar los datos requeridos...", Toast.LENGTH_SHORT).show()
            }

        }


    }
}