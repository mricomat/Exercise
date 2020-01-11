package com.example.exercise.data.network

/**
 * Generic call back for the response of the services
 */
interface OnResultCallback<T> {

    fun onSuccess(result: T)
    fun onError(t: Throwable?)

}