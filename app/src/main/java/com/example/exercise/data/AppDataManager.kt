package com.example.exercise.data

import com.example.exercise.data.model.TransactionModel
import com.example.exercise.data.network.OnResultCallback
import com.example.exercise.data.network.transactions.TransactionApiController

/**
 * Class in charge to manage all the data via web service of from DB
 *
 * TODO This class should be able in the future to have a generic manager(interface) to distribute ordered all data to the application
 */
class AppDataManager : DataManager {

    private val mTransactionController: TransactionApiController =
        TransactionApiController()

    override fun getTransactionsList(callback: OnResultCallback<ArrayList<TransactionModel>>) {
        return mTransactionController.getTransactionsList(callback)
    }
}