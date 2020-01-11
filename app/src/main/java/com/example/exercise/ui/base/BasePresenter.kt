package com.example.exercise.ui.base

interface BasePresenter<V> {

    fun onAttach(view: V)

    fun onDetach()
}