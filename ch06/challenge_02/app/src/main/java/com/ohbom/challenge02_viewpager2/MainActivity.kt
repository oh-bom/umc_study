package com.ohbom.challenge02_viewpager2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.ohbom.challenge02_viewpager2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy{
       ActivityMainBinding.inflate(layoutInflater)
    }
    private val icons=listOf(
        R.drawable.cloud,
        R.drawable.moon,
        R.drawable.rabbit,
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewPager.apply{
            adapter=viewPageAdapter(context as FragmentActivity)
            setPageTransformer(zoomOutPageTransformer())
        }

        TabLayoutMediator(binding.tabs,binding.viewPager){tab,position->
            tab.text="title $position"
            tab.setIcon(icons[position])
        }.attach()

        binding.to2activityBtn.setOnClickListener {
            val intent= Intent(this,secondActivity::class.java)
            startActivity(intent)
        }

    }
}