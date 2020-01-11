package com.example.exercise.data

import com.example.exercise.data.model.TransactionModel
import com.example.exercise.data.network.OnResultCallback

// TODO Implement all services interfaces and be able to manage all data inside this interface

interface DataManager {

    fun getTransactionsList(callback: OnResultCallback<ArrayList<TransactionModel>>)

}