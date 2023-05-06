package com.ohbom.umc_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ohbom.umc_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewBinding:ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.containerFragment.id,HomeFragment())
            .commitAllowingStateLoss()

        viewBinding.navBottom.run {
            setOnItemReselectedListener{
                when(it.itemId){
                    R.id.menu_home->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id,HomeFragment())
                            .commitAllowingStateLoss()
                    }

                    R.id.menu_setting->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id,settingFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }

            selectedItemId=R.id.menu_home //처음 실행시에는 저 menu_home으로 실행
        }
    }
}