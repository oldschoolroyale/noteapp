package com.brmlab.sqlite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brmlab.sqlite.databinding.ListItemBinding
import com.brmlab.sqlite.model.AccountPOJO

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var dataList = emptyList<AccountPOJO>()

    //новый список, который присваевается к dataList
    fun newList(newList: List<AccountPOJO>){
        this.dataList = newList
        notifyDataSetChanged()
    }
    private class RecyclerViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
        //Связка модели с элементом layout
        fun bind(model: AccountPOJO){
            binding.model = model
            binding.executePendingBindings()
        }
        //Обьявление нашего view holder'a
        companion object{
            fun from(parent: ViewGroup): RecyclerViewHolder{
                val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return RecyclerViewHolder(binding)
            }
        }
    }
    //Создание нашего VH
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RecyclerViewHolder.from(parent)
    }
    //резеварция элементов по размеру списка
    override fun getItemCount(): Int {
        return dataList.count()
    }
    //достаем модели из списка по одному
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is RecyclerViewHolder){
            holder.bind(dataList[position])
        }
    }
}