package com.example.exercise.ui.list

import com.example.exercise.data.model.TransactionModel
import com.example.exercise.ui.base.BaseView

interface ListView : BaseView {

    fun showTransactionsList(transactionsList: ArrayList<TransactionModel>)

    fun showLoading()

    fun hideLoading()

    fun showError()
}