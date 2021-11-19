package com.example.pastillero

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


class DataBase ( context : Context , name : String , factory: SQLiteDatabase.CursorFactory? , version: Int) :
    SQLiteOpenHelper(context,name,factory, version){



    override fun onCreate(db: SQLiteDatabase?) {

        val sql = "CREATE TABLE user (\n" +
                "\tid_user integer PRIMARY KEY AUTOINCREMENT,\n" +
                "\tuser text,\n" +
                "\tpassword varchar\n" +
                ");\n " +
                "" +
                "" +
                "CREATE TABLE gifts (\n" +
                "\tid_gifts integer PRIMARY KEY AUTOINCREMENT,\n" +
                "\tname_gift text\n" +
                ");\n" +
                "" +
                "CREATE TABLE special_date (\n" +
                "\tid_spcd integer PRIMARY KEY AUTOINCREMENT,\n" +
                "\tperson text,\n" +
                "\tevent text,\n" +
                "\tdate datetime,\n" +
                "\tid_thol integer,\n" +
                "\tid_user integer\n" +
                ");\n" +
                "" +
                "CREATE TABLE type_holidays (\n" +
                "\tid_thol integer PRIMARY KEY AUTOINCREMENT,\n" +
                "\tname_holiday text\n" +
                ");\n" +
                "" +
                "CREATE TABLE record_holiday (\n" +
                "\tid_record integer PRIMARY KEY AUTOINCREMENT,\n" +
                "\tid_spcd integer,\n" +
                "\tid_gifts integer\n" +
                ");\n"
        db!!.execSQL(sql)
        //Toast.makeText(this, "Base de Datos creada...",Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


}