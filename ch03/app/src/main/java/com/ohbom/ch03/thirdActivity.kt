package com.ohbom.ch03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ohbom.ch03.databinding.ActivityThirdBinding

class thirdActivity : AppCompatActivity() {
    private lateinit var binding:ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        binding=ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setFragment(firstFragment())

        binding.firstFragment.setOnClickListener {
            switchFragment(firstFragment())
        }

        binding.secondFragment.setOnClickListener {
            switchFragment(secondFragment())
        }

        //fragment에서 값 받아오기

        //1. intent 사용


        //2.
        supportFragmentManager
            .setFragmentResultListener("rqkey",this){requestKey,bundle->
                val result=bundle.getString("bundlekey")
                Toast.makeText(this,result,Toast.LENGTH_SHORT).show()

        }

        }




    //단순 fragment create
    private fun setFragment(frag: Fragment){
        val transaction=supportFragmentManager.beginTransaction()
            .add(R.id.fragmentArea,frag)
        transaction.commit()

    }

    var flag=0
    private fun switchFragment(frag:Fragment){
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentArea,frag)
        //transaction.replace(binding.fragmentArea,frag)
//        when (flag){
//            0->{
//                transaction.add(R.id.fragmentArea,frag)
//                flag=1
//            }
//            1->{
//                transaction.replace(R.id.fragmentArea,frag)
//            }
//
//        }

        transaction.addToBackStack(null)
        transaction.commit()

    }
}