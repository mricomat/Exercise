package com.example.exercise.ui.list.adapter

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise.R
import com.example.exercise.data.model.TransactionModel
import kotlinx.android.synthetic.main.item_transaction.view.*

class ListViewHolder(private val mItemView: View) : RecyclerView.ViewHolder(mItemView) {

    fun onBind(transaction: TransactionModel) {
        mItemView.descriptionText.text = transaction.description
        mItemView.dateText.text = transaction.date
        mItemView.amountTransactionText.text = transaction.totalAmount.toString()
        mItemView.lastAmountAccountText.text = transaction.lastAmountAccount.toString()
        when {
            transaction.totalAmount > 0 -> {
                mItemView.amountTransactionText.setTextColor(
                    ContextCompat.getColor(
                        mItemView.context,
                        R.color.green_transaction
                    )
                )
                mItemView.amountTransactionCurrencyText.setTextColor(
                    ContextCompat.getColor(
                        mItemView.context,
                        R.color.green_transaction
                    )
                )
            }
            else -> {
                mItemView.amountTransactionText.setTextColor(
                    ContextCompat.getColor(
                        mItemView.context,
                        R.color.red_transaction
                    )
                )
                mItemView.amountTransactionCurrencyText.setTextColor(
                    ContextCompat.getColor(
                        mItemView.context,
                        R.color.red_transaction
                    )
                )
            }
        }
    }

}