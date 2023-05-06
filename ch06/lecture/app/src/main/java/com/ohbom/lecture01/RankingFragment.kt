package com.ohbom.lecture01

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class RankingFragment: Fragment() {
    companion object{
        const val Tag:String="로그"

        fun newInstance():RankingFragment{
            return RankingFragment()
        }
    }


    //memory에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //fragment를 안고있는 액티비티에 붙었을때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG,"homeFragment-onAttach() called")

    }

    //view가 생성되었을때 화면과 연결
    //fragment와 layout연결
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d(TAG,"homeFragment-onCreate() called")

        val view=inflater.inflate(R.layout.fragment_ranking,container,false)
        return view
    }
}