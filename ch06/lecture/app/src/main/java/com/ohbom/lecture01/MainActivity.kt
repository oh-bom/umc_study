package com.ohbom.lecture01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(),BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private lateinit var homeFragment: HomeFragment
    private lateinit var rankingFragment: RankingFragment
    private lateinit var profileFragment: profileFragment

    companion object{
        const val TAG:String="로그"
    }

    //메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        setContentView(R.layout.activity_main)

        Log.d(TAG,"main activity oncreate() called")
        R.id.bottomNavigationView.onNavigationItemSelected(this)

    }

    private val onBottomNavItemSelectedListener=BottomNavigationView.onNavigationItemSelectedListener{

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_home->{
                Log.d(TAG,"홈버튼 클릭")
            }
            R.id.menu_ranking->{
                Log.d(TAG,"랭킹버튼 클릭")
            }
            R.id.menu_profile->{
                Log.d(TAG,"프로필 버튼 클릭")
            }
        }
        return true
    }
}