package com.ohbom.ch06_challenge

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class viewPageAdapter(fa:FragmentActivity):FragmentStateAdapter(fa){
    private val num_page=3
    override fun getItemCount(): Int=num_page

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{MyFragment.newInstance("moon","") }
            1->{MyFragment.newInstance("cloud","")}
            else->{MyFragment.newInstance("rabbit","")}
        }
    }


}