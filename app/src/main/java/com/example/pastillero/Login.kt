package com.example.pastillero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //declaración de variables
        val user = findViewById<EditText>(R.id.edt1)
        val password = findViewById<EditText>(R.id.edt2)
        val botonIngresar = findViewById<Button>(R.id.bt1)
        val botonRegistrar = findViewById<Button>(R.id.bt2)

        user.hint = "Introduce el Usuario"
        password.hint = "Introduce el password"


        //ingreso Usuario
        botonIngresar.setOnClickListener {

            if(user.text.toString().isEmpty())
            {
                Toast.makeText(this, "Debes introducir Usuario...", Toast.LENGTH_LONG).show()
            }
            else if(password.text.toString().isEmpty())
            {
                Toast.makeText(this, "Debes introducir Password...", Toast.LENGTH_LONG).show()
            }
            else
            {
                val admin = DataBase(this, "HB", null, 1)
                val db = admin.writableDatabase
                val sql : String = "select id_user,user from user where user ='${user.text.toString()}' and password ='${password.text.toString()}' "
                val row = db.rawQuery(sql, null)
                if (row.moveToFirst()) {
                    val dsc = row.getInt(row.getColumnIndex("id_user"))
                    val dsc2 = row.getString(row.getColumnIndex("user"))
                    if(dsc > 0)
                    {
                        val intento = Intent(this, MainActivity::class.java)
                        intento.putExtra("id",dsc)
                        intento.putExtra("user",dsc2)
                        startActivity(intento)
                    }
                }
                else {
                    Toast.makeText(this, "No hay registros...", Toast.LENGTH_SHORT).show()
                    db.close()
                }

            }

        }
        //Direccionar Registro Usuario
        botonRegistrar.setOnClickListener {

            val intent = Intent(this, RecordUser::class.java)
            startActivity(intent)

        }

    }
}