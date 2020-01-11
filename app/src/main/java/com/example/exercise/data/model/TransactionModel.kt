package com.example.exercise.data.model

data class TransactionModel (
    val id: Long,
    val date: String,
    val amount: Double,
    val fee: Double,
    val description: String?,
    val totalAmount: Double,
    var lastAmountAccount: Double
)