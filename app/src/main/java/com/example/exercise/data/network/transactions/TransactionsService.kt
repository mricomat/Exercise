package com.example.exercise.data.network.transactions

import com.example.exercise.data.model.TransactionModel
import retrofit2.Call
import retrofit2.http.GET

interface TransactionsService {

    @GET("1a30k8")
    fun getTransactionsList(): Call<ArrayList<TransactionModel>>

}