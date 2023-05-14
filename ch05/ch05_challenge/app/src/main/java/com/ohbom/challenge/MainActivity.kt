package com.ohbom.challenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ohbom.challenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var rvAdapter:rvAdapter
    val memos= mutableListOf<Memo>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        val db=AppDB.getInstance(this)
        val rv=binding.recyclerView
        rvAdapter=rvAdapter(memos)


        rv.adapter=rvAdapter
        rv.layoutManager=LinearLayoutManager(this)

        setResult(db!!)
        getMemos(db!!)


        binding.addBtn.setOnClickListener {
            var intent=Intent(this,insertMemoActivity::class.java)

            resultLauncher.launch(intent)//startAcitivity(intent)
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
                if(db!=null){
                    db.memoDao().insert(memo)
                }
                //rv만 구현했을때 쓰던거
                //memos.add(it)
                //binding.recyclerView.adapter?.notifyItemInserted(memos.size-1)
            }
        }
        }
    }

    fun getMemos(db:AppDB){
        if(db!=null){
        db.memoDao().selectAll().observe(this, Observer{x->
            memos.clear()
            memos.addAll(x)
            rvAdapter.notifyDataSetChanged()
        })}
    }
}
