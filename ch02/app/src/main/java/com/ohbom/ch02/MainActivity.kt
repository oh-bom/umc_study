package com.ohbom.ch02

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.ohbom.ch02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var handler:Handler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        mediaPlayer= MediaPlayer.create(this,R.raw.christmas)

        handler=Handler(Looper.getMainLooper())

        binding.play.setOnClickListener{
            mediaPlayer.start()
        }
        binding.pause.setOnClickListener{
            mediaPlayer.pause()
        }
    }
}