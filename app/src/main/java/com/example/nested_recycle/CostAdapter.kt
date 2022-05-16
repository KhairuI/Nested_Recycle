package com.example.nested_recycle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nested_recycle.databinding.CostSingleItemBinding

class CostAdapter(
    private val costList: MutableList<ModelCost>) : RecyclerView.Adapter<CostAdapter.CostViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CostViewHolder {
        return CostViewHolder(CostSingleItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
    }

    override fun getItemCount(): Int {
        return if (costList.isNullOrEmpty()) 0 else costList.size
    }

    override fun onBindViewHolder(holder: CostViewHolder, position: Int) {
        val cost = costList[position]
        holder.binding.apply {
            txtIncome.text= cost.income
            txtTax.text= cost.tax
            txtTax2.text= cost.tax2
            txtLoan.text= cost.loan
            txtLoan2.text= cost.loan2
            txtLoan3.text= cost.loan3
            txtLoan4.text= cost.loan4
            txtLoan5.text= cost.loan5


        }
    }

    class CostViewHolder(val binding: CostSingleItemBinding) : RecyclerView.ViewHolder(binding.root)
}