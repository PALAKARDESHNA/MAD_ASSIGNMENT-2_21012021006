package com.example.yogaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class sighup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sighup)
        supportActionBar?.hide()
       val sighup_btn : Button = findViewById(R.id.sighup_final_btn)
        sighup_btn.setOnClickListener{
             val db = DBController(this)

            val user = findViewById<TextView>(R.id.sighpage_username)
            val email = findViewById<TextView>(R.id.sighpage_email)
            val fullname = findViewById<TextView>(R.id.sighpage_fullname)
            val password = findViewById<TextView>(R.id.sighpage_password)

            val id = user.text.toString()
            val mail = email.text.toString()
            val name = fullname.text.toString()
            val pass = password.text.toString()

           db.Add_detail_database ( id , mail , name , pass )


Toast.makeText(this,"SighUp Successfully",Toast.LENGTH_LONG).show()
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
    }
}