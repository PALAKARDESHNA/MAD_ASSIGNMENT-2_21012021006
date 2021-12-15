package com.example.yogaapp

import android.widget.Toast

import android.content.Intent

import android.app.Service

import android.media.MediaPlayer

import android.os.IBinder

class service : Service() {
    private lateinit var mediaPlayer: MediaPlayer
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if(intent!=null){
            val data = intent.getStringExtra("service")
            if(!this::mediaPlayer.isInitialized){
                mediaPlayer = MediaPlayer.create(this,R.raw.yogamusic)
                mediaPlayer.isLooping = true
            }

            if(data=="play/pause"){
                if(!mediaPlayer.isPlaying){
                    mediaPlayer.start()
                }
                else{
                    mediaPlayer.pause()
                }
            }
        }
        else{
            mediaPlayer.start()
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer!!.stop()
        Toast.makeText(this, "Stopped", Toast.LENGTH_LONG).show()
    }
}