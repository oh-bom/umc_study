package com.ohbom.challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ohbom.challenge.databinding.ActivityInsertMemoBinding

class insertMemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInsertMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityInsertMemoBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.saveBtn.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java).apply{
                putExtra("str",binding.editText.getText().toString())
            }
            setResult(RESULT_OK,intent)
            if(!isFinishing) finish()
        }
    }


}