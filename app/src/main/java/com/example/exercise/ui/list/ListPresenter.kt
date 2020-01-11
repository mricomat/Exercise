package com.example.exercise.ui.list

import com.example.exercise.ui.base.BasePresenter

interface ListPresenter<V : ListView> : BasePresenter<V> {

    fun loadTransactions()

}