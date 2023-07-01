package com.ohbom.challenge

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.RoomDatabase
import com.ohbom.challenge.databinding.MemoItemsBinding
import kotlinx.coroutines.NonDisposableHandle.parent
import org.json.JSONArray
import org.json.JSONObject


class rvAdapter(val memos:List<Memo>,val sharedPref:SharedPreferences):RecyclerView.Adapter<rvAdapter.ViewHolder>() {
    val editor=sharedPref.edit()
    //val jsonArray=JSONArray()
    val jsonObject=JSONObject()
    var cnt=0

    private lateinit var binding:MemoItemsBinding

    //view Bindng 이전
//    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
//        fun bindItems(item: Memo){
//            val rv_text=itemView.findViewById<TextView>(R.id.rvItem)
//            rv_text.text=item.content
//        }
//    }

    //view Bindning 적용
    class ViewHolder(val binding:MemoItemsBinding):RecyclerView.ViewHolder(binding.root){
//        fun bind(data:List<Memo>){
//            binding.rvText.text=data[position].content
//        }

        fun bind(item:List<Memo>){
            binding.rvText.text=item[adapterPosition].content
            Log.d("problem","pp")
        }




    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvAdapter.ViewHolder {
        //view binding 이전
        //val view=LayoutInflater.from(parent.context).inflate(R.layout.memo_items,parent,false)
        //return ViewHolder(view)

        //view Binding
        val binding=MemoItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)//q. 왜 binding.root 아닐까?

    }

    override fun onBindViewHolder(holder: rvAdapter.ViewHolder, position: Int) {
        val memo=memos[holder.adapterPosition]

        holder.bind(memos)

        //click 시 삭제 구현했던 old ver
        //holder.bindItems(memos[position])
//            holder.itemView.setOnClickListener {
//               //     v-> itemClick?.onClick(v,position)
//                //memos.removeAt(position)
//                notifyItemRemoved(position)
//            }
//        binding.star.setOnClickListener {
//            val memo=memos[holder.adapterPosition]
//            Log.d("bookmark",memo.content)
//            jsonObject.put(memo.memoId.toString(),memo.content)
//            cnt+=1
//            //jsonArray.put(jsonObject)
//            Log.d("jsobject",jsonObject.toString())
//            editor.putString("bookMark",jsonObject.toString())
//            editor.putInt("cnt",cnt)
//            editor.apply()
//        }

        holder.itemView.setOnClickListener{

            Log.d("bookmark",memo.content)
            jsonObject.put(memo.memoId.toString(),memo.content)
            cnt+=1
            //jsonArray.put(jsonObject)
            Log.d("jsobject",jsonObject.toString())
            editor.putString("bookMark",jsonObject.toString())
            editor.putInt("cnt",cnt)
            editor.apply()
        }
        val switch=holder.binding.like
        switch.setOnClickListener {
            val status=switch.isChecked
            switch.isChecked=!status
            //db.memoDao().updateLikeByMemoId(memo.memoId,!status)

        }

        Log.d("finished?","finishe~~")
    }

    override fun getItemCount(): Int {
        return memos.size
    }

    interface ItemClick{
        fun onClick(view:View,position:Int)
    }

    var itemClick:ItemClick?=null



}