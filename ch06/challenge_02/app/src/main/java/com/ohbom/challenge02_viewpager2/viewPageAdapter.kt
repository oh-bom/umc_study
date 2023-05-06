package com.ohbom.challenge02_viewpager2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class viewPageAdapter(fa:FragmentActivity):FragmentStateAdapter(fa) {
    val num_pages=3
    override fun getItemCount(): Int = num_pages

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{MyFragment.newInstance("moon","")}
            1->{MyFragment.newInstance("cloud","")}
            else->{MyFragment.newInstance("rabbit","")}
        }
    }

}