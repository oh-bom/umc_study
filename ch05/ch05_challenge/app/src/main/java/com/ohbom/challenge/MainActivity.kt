package com.ohbom.challenge

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ohbom.challenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var rvAdapter:rvAdapter
    val memos= mutableListOf<Memo>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        val db = AppDB.getInstance(this)

        val sharedPref = getSharedPreferences(packageName, MODE_PRIVATE)
        val rv = binding.recyclerView
        rvAdapter = rvAdapter(memos, sharedPref)
        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(this)

        //setResult(db!!)

        //resultLauncher
        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val memoContent = result.data?.getStringExtra("str")
                Toast.makeText(this, memoContent, Toast.LENGTH_SHORT).show()
                memoContent?.let {
                    var memo = Memo(it)//Memo 객체 추가

                    db!!.memoDao().insert(memo)


                }
            }
        }
    }
    override fun onResume() {
        super.onResume()
        getMemos()

        //setOnClickListener
        binding.addBtn.setOnClickListener {
            var intent=Intent(this,insertMemoActivity::class.java)
            resultLauncher.launch(intent)//startAcitivity(intent)
        }

        binding.starBtn.setOnClickListener {
            var intent=Intent(this,BookMarkActivity::class.java)
            resultLauncher.launch(intent)
            //startActivity(intent)
        }

    }

    fun setResult(db:AppDB){
        //resultLauncher
        resultLauncher=registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
                result->if(result.resultCode== RESULT_OK){
            val memoContent=result.data?.getStringExtra("str")
            Toast.makeText(this,memoContent,Toast.LENGTH_SHORT).show()
            memoContent?.let{
                var memo=Memo(it)//Memo 객체 추가

                db.memoDao().insert(memo)

                //rv만 구현했을때 쓰던거
                //memos.add(it)
                //binding.recyclerView.adapter?.notifyItemInserted(memos.size-1)
            }
        }
        }
    }

    fun getMemos(){
        db!!.memoDao().selectAll().observe(this, Observer{x->
            memos.clear()
            memos.addAll(x)
            rvAdapter.notifyDataSetChanged()
        })
    }
}
