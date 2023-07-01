package com.ohbom.challenge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ohbom.challenge.databinding.BookmarkItemsBinding
import com.ohbom.challenge.databinding.MemoItemsBinding

class bookMarkRvAdapter(var memos:List<String>):RecyclerView.Adapter<bookMarkRvAdapter.ViewHolder>() {
    private lateinit var binding: BookmarkItemsBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): bookMarkRvAdapter.ViewHolder {
        binding= BookmarkItemsBinding.inflate(LayoutInflater.from(parent.context))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: bookMarkRvAdapter.ViewHolder, position: Int) {
        holder.bindItems(memos[position])
    }

    override fun getItemCount(): Int {
        return memos.size
    }

    inner class ViewHolder(val binding:BookmarkItemsBinding):RecyclerView.ViewHolder(binding.root){
        fun bindItems(item:String){
            binding.rvText.text=item

        }
    }

    fun updateList(newList:List<String>){
        memos=newList
        notifyDataSetChanged()

    }
}