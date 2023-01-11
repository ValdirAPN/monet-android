package com.vpn.monet.domain.repositories

import com.vpn.monet.data.entities.TransactionEntity
import com.vpn.monet.domain.models.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionsRepository {
    suspend fun getTransactions() : Flow<List<Transaction>>
    suspend fun getIncomeTransactions() : Flow<List<Transaction>>
    suspend fun getOutcomeTransactions() : Flow<List<Transaction>>
    fun createTransaction(transactionEntity: TransactionEntity)
}