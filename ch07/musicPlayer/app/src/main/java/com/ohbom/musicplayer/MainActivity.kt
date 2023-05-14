package com.ohbom.musicplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.SeekBar
import com.ohbom.musicplayer.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mp: MediaPlayer
    private lateinit var handler:Handler
    private lateinit var seekBar:SeekBar
    var musicLength=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //초기 viewBinding
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //변수 선언들
        mp=MediaPlayer.create(this,R.raw.music)
        musicLength=mp.duration
        handler= Handler(Looper.getMainLooper())
        seekBar=binding.seekBar
        seekBar.setMax(mp.duration)

        var isPlaying=false
        //onClickListener
        binding.play.setOnClickListener{
            if(!isPlaying){
                play()
                binding.play.setImageResource(R.drawable.pause)
                isPlaying=true
            }
            else{
                mp.pause()
                binding.play.setImageResource(R.drawable.play)
                isPlaying=false
            }

        }

        binding.stop.setOnClickListener{
            stop()
        }

        binding.seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //var sbTime=formatTime(progress)
                //binding.seekBarText.text="$sbTime"
                if(fromUser) {
                    mp.seekTo(progress)
                    var sbTime=formatTime(progress/1000)
                    //binding.playTime.text=sbTime
                    binding.currentPosition.text=sbTime
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //var sbTime=formatTime(seekBar!!.progress)
                //binding.seekBarText.text="$sbTime"
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })



    }

    var count=0
    fun play(){
        mp.start()
        binding.musicLength.text=formatTime(musicLength/1000)
        //1. hanlder사용
        handler.postDelayed(object:Runnable{
            override fun run() {
                if(mp.isPlaying){
                    var currentPosition=mp.currentPosition
                    var sbTime=formatTime(currentPosition/1000)
                    binding.currentPosition.text=sbTime
                    seekBar.setProgress(currentPosition)
                    handler.postDelayed(this,1000)

                }
            }

        },0)

        //2.seekBar update
        //handler.post(updateSeekBar)

        //내가했던 코드..
//        thread(start=true){
//            while(mp.isPlaying()){
//                Thread.sleep(1000)
//                count+=1
//                binding.playTime.text=formatTime(count)//시간 띄우기
//                seekBar.setProgress(mp.currentPosition)//seekbar위치 설정
//           }
//        }
    }

    fun stop(){
        mp.pause()
        mp.seekTo(0)
        seekBar.setProgress(mp.currentPosition)
        binding.currentPosition.text="00:00"

    }

    //2 updateSeekBar thread에 runnable객체 생성하여 내부에서
    //ui 업데이트 수행
    val updateSeekBar:Runnable=object :Runnable{
        override fun run() {
            if(mp.isPlaying) {
                count++
                binding.currentPosition.text=formatTime(count)
                seekBar.progress=mp.currentPosition
            }
            handler.postDelayed(this,1000)
        }

    }

    fun formatTime(time:Int):String{
        var minute=String.format("%02d",time/60)
        var second=String.format("%02d",time%60)
        return "$minute:$second"
    }

}