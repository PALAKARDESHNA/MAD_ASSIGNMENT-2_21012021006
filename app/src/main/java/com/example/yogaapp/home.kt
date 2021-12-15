package com.example.yogaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        val log_btn:Button = findViewById<Button>(R.id.login_btn)
        val sigh_btn:Button = findViewById<Button>(R.id.sighup_btn)

        log_btn.setOnClickListener{
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
        sigh_btn.setOnClickListener{
            val intent = Intent(this, sighup::class.java)
            startActivity(intent)
        }
    }
}