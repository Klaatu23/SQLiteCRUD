package com.example.pastillero

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.ArrayList

class Gifts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gifts)
        //Uso de la BD
        val admin = DataBase(this, "HB", null, 1)
        val db = admin.writableDatabase
        val sql : String = "select id_gifts,name_gift from gifts"
        //Declaracion de variables
        val gift = findViewById<EditText>(R.id.edt1)
        val btn1 = findViewById<Button>(R.id.bt1)
        val btn2 = findViewById<Button>(R.id.bt2)
        val btn3 = findViewById<Button>(R.id.bt3)
        val btn4 = findViewById<Button>(R.id.bt4)
       //Lista donde se mostraran los datos de la BD
        val lista = findViewById<ListView>(R.id.list)
        //Array donde se agregaran datos a mostrar en la lista
        val valores = ArrayList<String>()
        //Inicializa por default leyenda a mostrar
        valores.add("Gifts registrados:")
       //Ejecución y uso de cursor de la BD
        val row = db!!.rawQuery(sql, null)
        while(row.moveToNext()) {
            var cursor = row.getString(row.getColumnIndex("name_gift"))
            valores.add(cursor)
        }
        val adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,valores)
        lista.adapter = adaptador1
        //Boton Consultar
        btn1.setOnClickListener {
            val sql : String = "select id_gifts from gifts where name_gift ='${gift.text.toString()}'"
            val row = db.rawQuery(sql, null)
            if (row.moveToFirst()) {
                val id = row.getInt(row.getColumnIndex("id_gifts"))
                if(id > 0)
                {
                    Toast.makeText(this, "Registro encontrado...", Toast.LENGTH_SHORT).show()
                    lista.setSelection(id)
                }
            }
            else {
                Toast.makeText(this, "No hay registros...", Toast.LENGTH_SHORT).show()
                lista.setSelection(0)
            }

         }
    //Boton Registrar
        btn2.setOnClickListener {
            val record = ContentValues()
            record.put("name_gift",gift.text.toString())
            var id = db.insert("gifts",null,record)
            db.close()
            if(id > 0) {
                Toast.makeText(this, "Gift registrado...", Toast.LENGTH_SHORT).show()
                startActivity(getIntent());
            }else{
                Toast.makeText(this, "Ha ocurrido algo...", Toast.LENGTH_SHORT).show()
            }

        }
    //Boton Elmininar

    //Boton Actualizar
    }
}