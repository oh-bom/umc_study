package com.ohbom.challenge02_viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.ohbom.challenge02_viewpager2.databinding.ActivitySecondBinding

class secondActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondBinding

    private val image_names=listOf(
        "airplane",
        "smile",
        "pink Lake"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySecondBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.viewPager.apply{
            adapter=secondAdapter(context as FragmentActivity)
        }

        binding.indicators.setViewPager(binding.viewPager)


        TabLayoutMediator(binding.tabs,binding.viewPager){tab,position->
            tab.text=image_names[position]
        }.attach()
    }
}