package com.ohbom.ch06_challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ohbom.ch06_challenge.databinding.ActivityMainBinding
import com.ohbom.ch06_challenge.databinding.FragmentMyBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(binding.mainContainer.id,cloudFragment())
            .commitAllowingStateLoss()

        binding.bottomNavigationView.run{
            setOnItemSelectedListener {
                when(it.itemId){
                    R.id.menu_moon->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.mainContainer.id,moonFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_rabbit->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.mainContainer.id,rabbitFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_cloud->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(binding.mainContainer.id,cloudFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }


        }
    }
}