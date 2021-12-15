package com.example.yogaapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class DBController(context : Context) {
    var Dbhelper : dbhelper? = null
    private lateinit var database : SQLiteDatabase
    init{
        Dbhelper = dbhelper(context)
    }


    fun verifyUser(email : String, password: String):Boolean{
        database = Dbhelper?.readableDatabase!!

        val cursor: Cursor = database.rawQuery(
            "Select * from ${dbhelper.TABLE_NAME} where ${dbhelper.EMAIL_COL}=? and ${dbhelper.PASSWORD_COL}=?",
            arrayOf(email, password)
        )
        cursor.moveToFirst()

        return cursor.count > 0
    }


    fun Add_detail_database ( username:String , email:String , fullname:String , password:String )
    {
        val values = ContentValues()

        values.put(dbhelper.USERNAME_COL,username)
        values.put(dbhelper.EMAIL_COL,email)
        values.put(dbhelper.FULLNAME_COL,fullname)
        values.put(dbhelper.PASSWORD_COL,password)

        database = Dbhelper?.writableDatabase!!
        database.insert(dbhelper.TABLE_NAME,null,values)

        database.close()
    }
}