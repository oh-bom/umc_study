package com.ohbom.ch03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ohbom.ch03.databinding.ActivityMainBinding
import com.ohbom.ch03.databinding.ActivitySecondBinding

class secondActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val secondIntent=intent

        binding.text2.text=secondIntent.getStringExtra("editText")

        binding.btn.setOnClickListener {
            startActivity(Intent(this,thirdActivity::class.java))
        }

        binding.backbtn.setOnClickListener {
            intent.putExtra("backString","back!")
            setResult(RESULT_OK,intent)
            finish()

        }

    }
}