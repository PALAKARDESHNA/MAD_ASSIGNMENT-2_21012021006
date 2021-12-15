package com.example.yogaapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.service.autofill.UserData
import androidx.core.content.contentValuesOf

class dbhelper(context: Context):
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{

        private val DATABASE_NAME = "USERNAME"

        private val DATABASE_VERSION = 1

        val TABLE_NAME = "user_data_table"

        val USERNAME_COL = "userid"

        val FULLNAME_COL = "name"

        val EMAIL_COL = "email"

        val PASSWORD_COL = "password"

    }

    override fun onCreate( db : SQLiteDatabase?) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + USERNAME_COL + " TEXT , " +
                EMAIL_COL + " TEXT PRIMARY KEY," +
                FULLNAME_COL + " TEXT, " +
                PASSWORD_COL + " TEXT " + ")")
        db?.execSQL(query)

    }



    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val query = "CREATE TABLE $TABLE_NAME"
        p0?.execSQL(query)
    }




    }

