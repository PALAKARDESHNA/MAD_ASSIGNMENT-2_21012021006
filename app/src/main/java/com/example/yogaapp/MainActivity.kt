package com.example.yogaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val animation = AnimationUtils.loadAnimation(this,R.anim.slash_animation)
        val text1: TextView = findViewById<TextView>(R.id.text_yoga)
        text1.startAnimation(animation)
        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this@MainActivity, home::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}