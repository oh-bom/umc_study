package com.ohbom.ch03

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.ohbom.ch03.databinding.FragmentFirstBinding

class firstFragment : Fragment() {

    private lateinit var binding:FragmentFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFirstBinding.inflate(layoutInflater)

        //fragment->third activity
        //1. intent 사용
//        binding.sendbtn.setOnClickListener {
//            val intent=Intent(context,thirdActivity::class.java)
//
//            intent.putExtra("text",binding.editText.toString())
//            activity.startActivityForResult(intent,101)
//        }

        //2. fragmentResult 사용
        binding.sendbtn.setOnClickListener {
            val result=binding.editText.getText().toString()
            Log.d("result",result)
            setFragmentResult("rqkey", bundleOf("bundlekey" to result))

        }

        return binding.root
        //return inflater.inflate(R.layout.fragment_first, container, false)
    }


}