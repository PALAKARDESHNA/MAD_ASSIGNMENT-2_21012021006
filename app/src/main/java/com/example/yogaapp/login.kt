package com.example.yogaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        val login_click_btn = findViewById<Button>(R.id.login_click_btn)
        val loginEmail = findViewById<TextInputEditText>(R.id.loginpage_mail)
        val loginPassword = findViewById<TextInputEditText>(R.id.loginpage_password)
        login_click_btn.setOnClickListener {
            val dbController = DBController(this)
            if(dbController.verifyUser(loginEmail.text.toString(),loginPassword.text.toString())){
                val intent = Intent(this, Yoga_List_View::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "No User Found Please Signup first!", Toast.LENGTH_LONG).show()
                }
        }
    }
}