package com.ohbom.timer

import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AlertDialog
import com.ohbom.timer.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener{
            start()
        }

        binding.pauseBtn.setOnClickListener {
            pause()
        }

        binding.endBtn.setOnClickListener {
            stop()
        }

    }

    val SET_TIME=-1
    val RESET=0
    var ALERT_TIME=0
    var total=0
    var started=false

    //soundPool 객체 생성
//    val sp=SoundPool.Builder().setMaxStreams(10).build()
//    val soundId=sp.load(this,R.raw.alert,1)



    //handler
    val handler=object:Handler(Looper.myLooper()!!){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            //무한 루프 돌다가 메시지 들어오면, 꺼내와서 실행
            when(msg.what){//분기 처리 방법
                SET_TIME->{
                    val total=msg.arg1
                    binding.timer.text=formatTime(total)
                }
                ALERT_TIME->{
                    alertDialog()
                    //sp.play(soundId,1.0f,1.0f,0,3,1.0f)
                    stop()

                }
                RESET->{
                    binding.timer.text="00:00"
                }
            }


        }
    }





    fun start(){
        started=true

        ALERT_TIME=binding.alertTime.getText().toString().toInt()

        //sub thread
        thread(start=true) { //start는 ㄹㅇ thread한테 시작해~
            while(true){
                Thread.sleep(1000)
                if(!started) break
                total+=1

                //sub thread는 ui에 바로 접근할 수 없기 때문!
//                runOnUiThread{
//                    binding.timer.text=formatTime(total)
//                } //handler가 포함된거임

                val msg=Message()
                msg.arg1=total
                if(total==ALERT_TIME) msg.what=ALERT_TIME
                else msg.what=SET_TIME
                handler.sendMessage(msg)
            }
        }
    }

    fun alertDialog(){
        val builder=AlertDialog.Builder(this)

        builder.setTitle("timer")
            .setMessage("설정한 시간이 되었습니다")
            .setIcon(R.drawable.alarm)
            .setPositiveButton("YES"){dialog,which->
                //sp.release()
                dialog.dismiss()

            }
            .create()
            .show()


    }

    fun pause(){
        started=false

    }

    fun stop(){
        started=false
        total=0
        binding.timer.text="00:00"

    }

    fun formatTime(time:Int):String{
        val minute=String.format("%02d",time/60)
        val second=String.format("%02d",time%60)
        return "$minute : $second"
    }
}