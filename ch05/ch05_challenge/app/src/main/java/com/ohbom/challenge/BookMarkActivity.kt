package com.ohbom.challenge

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.ohbom.challenge.databinding.ActivityBookMark2Binding
import org.json.JSONObject

class BookMarkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookMark2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBookMark2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        val sp=getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val bmemos=sp.getString("bookMark","?")
        if(bmemos!=null){
            Log.d("bmemos",bmemos)

        }
        val cnt=sp.getInt("cnt",0)
        Log.d("cnt",cnt.toString())
        val memos=mutableListOf<String>()
        var jsonObject= JSONObject()

        try{
            bmemos?.let {jsonObject= JSONObject(bmemos) }
            if(cnt!=0){
                for(i in 1..cnt){
                    var content=jsonObject.getString(i.toString())
                    Log.d("myreceive",content)
                    memos.add(content)
                }
            }
        }
        catch(e:Exception){
            Log.d("e","sibal")
        }
        val rv=binding.bookMarkRV
        val bookMarkAdapter=bookMarkRvAdapter(memos)
        bookMarkAdapter.updateList(memos)
        rv.adapter=bookMarkAdapter
        rv.layoutManager= LinearLayoutManager(this)



    }
}