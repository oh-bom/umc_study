package com.ohbom.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.ohbom.listview.databinding.ListviewItemBinding

class customAdapter(context: Context,private val businessCardArrayList:ArrayList<BusinessCard>):BaseAdapter() {

    private val inflater=context.getSystemService((Context.LAYOUT_INFLATER_SERVICE))
    private lateinit var binding:ListviewItemBinding



    override fun getCount(): Int=businessCardArrayList.size

    override fun getItem(p0: Int): Any=businessCardArrayList[p0]

    override fun getItemId(p0: Int): Long=p0.toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        binding= ListviewItemBinding.inflate(inflater as LayoutInflater,p2,false)
        binding.nameListviewItem.text=businessCardArrayList[p0].name
        binding.contentsListviewItem.text=businessCardArrayList[p0].contents

        return binding.root
    }

}