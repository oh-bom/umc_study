package com.ohbom.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import com.ohbom.listview.databinding.ActivityMainBinding

data class BusinessCard(val name:String, val contents:String)

class MainActivity : AppCompatActivity() {
    var businessCardArrayList=ArrayList<BusinessCard>()

    private lateinit var customAdapter: customAdapter
    
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        for(x in 0..30){
            businessCardArrayList.add(BusinessCard("oh","bom"))
        }

        customAdapter=customAdapter(this,businessCardArrayList)
        binding.listviewMain.adapter=customAdapter

    }
}