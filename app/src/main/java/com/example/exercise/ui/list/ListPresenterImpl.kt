package com.example.exercise.ui.list

import android.os.Build
import android.util.Log
import com.example.exercise.data.AppDataManager
import com.example.exercise.data.network.OnResultCallback
import com.example.exercise.data.model.TransactionModel
import com.example.exercise.ui.base.BasePresenterImpl
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import kotlin.math.round

/** Presenter in charge of load and treat the data of the ListScreen,
 *  and once be ready, call to the view to show it
 *
 *  TODO Implement data injections, to don't have to worry about the instance of DataManager and the actual Presenter
 */

class ListPresenterImpl<V : ListView>(private var mDataManager: AppDataManager = AppDataManager()) :
    BasePresenterImpl<V>(), ListPresenter<V> {

    // Format Date constants
    private val DATE_SERVICE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"
    private val DATE_FORMAT = "EEE, d MMM yyyy HH:mm"

    private var mAccountAmountMock: Double = 2453.20
    //private var mDataManager: AppDataManager = AppDataManager()
    private var mTransactionsList: ArrayList<TransactionModel> = ArrayList()

    /** Once the view is attached to the presenter, we can call to the service **/

    override fun onAttach(view: V) {
        super.onAttach(view)
        loadTransactions()
    }

    /**
     * Fetch the information from webService using the DataManager only if we haven't done yet
     */
    override fun loadTransactions() {
        if (mTransactionsList.isEmpty()) {
            getMvpView()?.showLoading()
            mDataManager.getTransactionsList(object :
                OnResultCallback<ArrayList<TransactionModel>> {
                override fun onSuccess(result: ArrayList<TransactionModel>) {
                    Log.i("onSuccess ", "")
                    mTransactionsList = formatTransactions(result)
                    getMvpView()?.showTransactionsList(mTransactionsList)
                }

                override fun onError(t: Throwable?) {
                    Log.i("getTransactionsList ", t.toString())
                    getMvpView()?.showError()
                }
            })
        }
    }

    /** Method to sort, filter the transactions and format some fields of them **/

    fun formatTransactions(transactionsList: ArrayList<TransactionModel>): ArrayList<TransactionModel> {
        val formattedTransactionList: ArrayList<TransactionModel> = ArrayList()
        transactionsList.sortByDescending { it.date }
        transactionsList.reverse()
        transactionsList.forEach {
            if (isCorrectDateFormat(it.date)) {
                val resultTotalAmount = it.amount + it.fee
                formattedTransactionList.add(
                    it.copy(
                        totalAmount = round(resultTotalAmount * 100) / 100,
                        lastAmountAccount = round(mAccountAmountMock * 100) / 100,
                        date = formatDate(it.date)
                    )
                )
                mAccountAmountMock += resultTotalAmount
            }
        }

        formattedTransactionList.reverse()
        return formattedTransactionList
    }

    /** Checks from the format of the given service if the value follows that one **/

    private fun isCorrectDateFormat(value: String): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            try {
                val dateServiceFormatter = DateTimeFormatter.ofPattern(DATE_SERVICE_FORMAT)
                val date = dateServiceFormatter.parse(value)

                if (value != dateServiceFormatter.format(date)) {
                    return false
                }

                return true
            } catch (ex: DateTimeParseException) {
                return false
            }
        } else {
            return false
            TODO("VERSION.SDK_INT < O")
        }
    }

    /** Format to the new format to make it more easy to read **/

    private fun formatDate(value: String): String {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return return try {
                val newPattern = DateTimeFormatter.ofPattern(DATE_FORMAT)
                val oldPattern = DateTimeFormatter.ofPattern(DATE_SERVICE_FORMAT)
                val oldDate = oldPattern.parse(value)

                newPattern.format(oldDate)
            } catch (ex: DateTimeParseException) {
                Log.i("DateTimeParseException", ex.toString())
                ""
            }
        } else {
            return ""
            TODO("VERSION.SDK_INT < O")
        }
    }
}