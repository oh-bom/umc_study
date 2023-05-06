package com.ohbom.challenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class rvAdapter(val memos:MutableList<String>):RecyclerView.Adapter<rvAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvAdapter.ViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.memo_items,parent,false)
        return ViewHolder(view)
    }

    interface ItemClick{
        fun onClick(view:View,position:Int)
    }

    var itemClick:ItemClick?=null

    override fun onBindViewHolder(holder: rvAdapter.ViewHolder, position: Int) {
        holder.bindItems(memos[position])
            holder.itemView.setOnClickListener {
               //     v-> itemClick?.onClick(v,position)
                memos.removeAt(position)
                notifyItemRemoved(position)
            }

    }

    override fun getItemCount(): Int {
        return memos.size
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindItems(item:String){
            val rv_text=itemView.findViewById<TextView>(R.id.rvItem)
            rv_text.text=item
        }
    }
}