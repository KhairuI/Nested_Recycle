package com.example.nested_recycle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nested_recycle.databinding.InfoSingleItemBinding

class InfoAdapter(
    private val infoList: MutableList<ModelInfo>) : RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): InfoViewHolder {
        return InfoViewHolder(InfoSingleItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
    }

    override fun getItemCount(): Int {
        return if (infoList.isNullOrEmpty()) 0 else infoList.size
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        val info = infoList[position]
        holder.binding.apply {
            txtID.text= "${info.id}"
            txtName.text= info.name
            txtAge.text= info.age

        }
    }

    class InfoViewHolder(val binding: InfoSingleItemBinding) : RecyclerView.ViewHolder(binding.root)
}