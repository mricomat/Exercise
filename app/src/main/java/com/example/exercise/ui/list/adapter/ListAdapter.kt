package com.example.exercise.ui.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise.R
import com.example.exercise.data.model.TransactionModel

class ListAdapter(private var mTransactionsList: ArrayList<TransactionModel>) :
    RecyclerView.Adapter<ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_transaction, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        if (mTransactionsList.isNotEmpty()) {
            holder.onBind(mTransactionsList[position])
        }
    }

    override fun getItemCount(): Int {
        return mTransactionsList.size
    }

    fun addList(transactionsList: ArrayList<TransactionModel>) {
        mTransactionsList.addAll(transactionsList)
        notifyDataSetChanged()
    }

}