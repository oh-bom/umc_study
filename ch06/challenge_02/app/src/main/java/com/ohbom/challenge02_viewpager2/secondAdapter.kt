package com.ohbom.challenge02_viewpager2

import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class secondAdapter(fa:FragmentActivity):FragmentStateAdapter(fa) {
    private val images= listOf(
        R.drawable.airplane_01,
        R.drawable.happysmile2,
        R.drawable.pinklake_01,
    )
    private val names=listOf(
        "airplane",
        "smile",
        "pink",
    )
    override fun getItemCount(): Int=images.size

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->airplaneFragment()
            1->smileFragment()
            else->pinkFragment()

    }
}
}
