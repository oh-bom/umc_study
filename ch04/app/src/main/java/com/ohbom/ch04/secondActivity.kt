package com.ohbom.ch04

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.ohbom.ch04.databinding.ActivitySecondBinding

class secondActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySecondBinding
    private lateinit var memo:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val secondIntent=intent
        binding.memoArea.text=secondIntent.getStringExtra("memo")

//        binding.restartbtn.setOnClickListener {
//            val builder=AlertDialog.Builder(this)
//                .setTitle("memo restart")
//                .setMessage("메모 수정 할 거라구요~?")
//                .setPositiveButton("확인",
//                DialogInterface.OnClickListener{dialog,which->
//                Toast.makeText(this,"확인",Toast.LENGTH_SHORT).show()})
//                .setNegativeButton("취소",DialogInterface.OnClickListener { dialogInterface, i ->
//                    Toast.makeText(this,"취소",Toast.LENGTH_SHORT).show()
//                })
//            builder.show()
//                }
        }



}