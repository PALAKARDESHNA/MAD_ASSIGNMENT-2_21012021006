package com.example.yogaapp

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class detail_yoga_pose : AppCompatActivity() {
    var counter = 0
    private lateinit var StartButton:Button
    private lateinit var timerTextView : TextView
    private lateinit var timerCounter:CountDownTimer
    var start = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_yoga_pose)
        supportActionBar?.hide()

        StartButton = findViewById(R.id.button)
        timerTextView = findViewById(R.id.timer)

        if(intent!=null) {

            val name = intent.getStringExtra("name")
            val type = intent.getStringExtra("type")
            val time = intent.getStringExtra("time")
            val img = intent.getIntExtra("img", R.drawable.yoga1)

            val name1: TextView = findViewById(R.id.name)
            name1.text = name

            val type1: TextView = findViewById(R.id.type)
            type1.text = type

            val time1: TextView = findViewById(R.id.time)
            time1.text = time

            val img1: ImageView = findViewById(R.id.img)
            img1.setImageResource(img)

        }
        else{
            Log.e("Detail Yoga:" ," Error")
        }

        StartButton.setOnClickListener{
            if(!start) {
                startTimeCounter()
                timerCounter.start()
                StartButton.text = "Stop"
                startStopService("start")
            }
            else{
                timerCounter.cancel()
                StartButton.text = "Start"
                startStopService("stop")

            }
            start = !start
        }
    }

   fun startTimeCounter()
    {
        timerCounter = object:CountDownTimer(120000,1000)
        {
            override fun onTick(millisUntilFinished : Long) {
                timerTextView.text = counter.toString()
                counter++
            }

            override fun onFinish() {
                val sec:TextView = findViewById(R.id.textView5)
                sec.text = ""
                counter = 0
                startStopService("stop")
            }
        }
    }
    private fun startStopService(service : String){
        if(service=="start") {
            Intent(applicationContext, com.example.yogaapp.service::class.java).apply {
                putExtra("service", "play/pause")
                startService(this)
            }
        }
        else if(service=="stop"){
            counter = 0
            Intent(applicationContext, com.example.yogaapp.service::class.java).apply {
                putExtra("service", "play/pause")
                stopService(this)
            }
        }
    }
}