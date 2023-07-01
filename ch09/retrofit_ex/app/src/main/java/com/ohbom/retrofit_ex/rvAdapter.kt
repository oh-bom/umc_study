package com.ohbom.retrofit_ex


import android.support.annotation.NonNull
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ohbom.retrofit_ex.databinding.ItemListBinding

//

class rvAdapter: ListAdapter <Data, rvAdapter.rvViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return rvViewHolder(binding)
    }

    override fun onBindViewHolder(holder: rvViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class rvViewHolder(val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Data) {
            with(binding) {
                hname.text=item.centerName
                address.text=item.address
                cityName.text=item.sido
                phoneNumber.text=item.phoneNumber
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }
        }
    }
}




//class rvAdapter(val datas:List<Data>):RecyclerView.Adapter<rvAdapter.ViewHolder>(){
//
//    private lateinit var binding: ItemListBinding
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvAdapter.ViewHolder {
//
//        val binding=ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: rvAdapter.ViewHolder, position: Int) {
//        val data=datas[holder.adapterPosition]
//        holder.bind(datas)
//    }
//
//    override fun getItemCount(): Int {
//        return datas.size
//    }
//
//    inner class ViewHolder(val binding: ItemListBinding):RecyclerView.ViewHolder(binding.root){
//        fun bind(item:List<Data>){
//            binding.hname.text=item[adapterPosition].centerName
//            binding.address.text=item[adapterPosition].address
//            binding.cityName.text=item[adapterPosition].sido
//            binding.phoneNumber.text=item[adapterPosition].phoneNumber
//
//        }
//
//    }
//
//}


//class rvAdapter:ListAdapter<Data,rvAdapter.rvViewHolder>(DiffCallback){
//    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):rvViewHolder{
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val binding=ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return rvViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: rvViewHolder,position:Int){
//        holder.bind(getItem(position))
//    }
//
//    inner class rvViewHolder(private val binding:ItemListBinding):
//            RecyclerView.ViewHolder(binding.root){
//                fun bind(item:Data){
//                    with(binding){
//                        hname.text=item.centerName
//                        address.text=item.address
//                        phoneNumber.text=item.phoneNumber
//                        cityName.text=item.sido
//                    }
//                }
//            }
//
//    companion object{
//        private val DiffCallback=object:DiffUtil.ItemCallback<Data>(){
//            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
//                return oldItem.hashCode()==newItem.hashCode()
//            }
//
//            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
//                return oldItem==newItem
//            }
//        }
//    }
//}