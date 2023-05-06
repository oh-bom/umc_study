package com.ohbom.challenge

import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.ohbom.challenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    val memos= mutableListOf<String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        val rv=binding.recyclerView
        val rvAdapter=rvAdapter(memos)
        memos.add("default")

        setResult()
        rv.adapter=rvAdapter
        rv.layoutManager=LinearLayoutManager(this)


        binding.addBtn.setOnClickListener {
            var intent=Intent(this,insertMemoActivity::class.java)

            resultLauncher.launch(intent)//startAcitivity(intent)
        }


    }

    fun setResult(){
        //resultLauncher
        resultLauncher=registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
                result->if(result.resultCode== RESULT_OK){
            val memo=result.data?.getStringExtra("str")
            Toast.makeText(this,memo,Toast.LENGTH_SHORT).show()
            memo?.let{
                memos.add(it)
                binding.recyclerView.adapter?.notifyItemInserted(memos.size-1)
            }
        }
        }
    }
}
