package com.example.exercise.data.network.transactions

import android.util.Log
import com.example.exercise.data.model.TransactionModel
import com.example.exercise.data.network.OnResultCallback
import com.example.exercise.data.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransactionApiController {

    private var mApiClient: TransactionsService? = null

    init {
        mApiClient = RetrofitClient.client.create(TransactionsService::class.java)
    }

    fun getTransactionsList(callback: OnResultCallback<ArrayList<TransactionModel>>) {

        val call = mApiClient?.getTransactionsList()

        call?.enqueue(object : Callback<ArrayList<TransactionModel>> {

            override fun onResponse(
                call: Call<ArrayList<TransactionModel>>?,
                response: Response<ArrayList<TransactionModel>>?
            ) {
                if (response?.isSuccessful!!) {
                    response.body()?.let { callback.onSuccess(it) }
                }
            }

            override fun onFailure(call: Call<ArrayList<TransactionModel>>, t: Throwable) {
                Log.d("onFailure", t.toString())
                callback.onError(t)
            }

        })

    }
}