package com.ohbom.ch03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.ohbom.ch03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var resultLauncher:ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editText1=binding.editText
        val sendbtn=binding.sendbtn

        setResult()


        sendbtn.setOnClickListener {
            Toast.makeText(this,"send", Toast.LENGTH_SHORT).show()
            var intent= Intent(this,secondActivity::class.java)
            intent.putExtra("editText",editText1.getText().toString())

            resultLauncher.launch(intent) //startActivity(intent) 와 동일

        }
    }

    private fun setResult(){

        resultLauncher=registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){result->
            if(result.resultCode==RESULT_OK){
                Toast.makeText(this,result.data?.getStringExtra("backString"),Toast.LENGTH_SHORT).show()
            }
        }




    }

}