package com.ohbom.ch04

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ohbom.ch04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var memo:String=""
    var state="default"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


    }

    override fun onResume() {
        super.onResume()
        //중지 되어 있떤 액티비티가 다시 실행
        val intent=Intent(this,secondActivity::class.java)

        Log.d("test",state)

        //state=default 처음 생성된 상태
        //state=2 메모내용 수정 X->그냥 다음 activity로 넘어가요
        if (state=="unchanged") startActivity(intent)

        else{
            if(state=="change") binding.editText.hint=memo
            //state=3이미 작성되었던 메모가 있을시에는 hint띄우기

            binding.button.setOnClickListener {
                memo=binding.editText.getText().toString()
                intent.putExtra("memo",memo)
                startActivity(intent)
            }

        }

    }

    override fun onPause() {
        super.onPause()
        //중지 상태
        //(홈버튼 눌러서 잠깐 빠져나갔을때, 다른 액티비티가 활성화 되었을때)
        memo=binding.editText.getText().toString()

    }

    override fun onRestart() {
        super.onRestart()
            val builder = AlertDialog.Builder(this)
                .setTitle("memo modify")
                .setMessage("메모 수정 할 거라구요~?")
                .setPositiveButton("확인",
                    DialogInterface.OnClickListener { dialog, which ->
                        state = "change"
                        Toast.makeText(this, "확인", Toast.LENGTH_SHORT).show()

                    })
                .setNegativeButton("취소", DialogInterface.OnClickListener { dialogInterface, i ->
                    state = "unchanged"
                    Toast.makeText(this, "취소", Toast.LENGTH_SHORT).show()

                })
            builder.show()
            binding.editText.getText().clear()

    }





}