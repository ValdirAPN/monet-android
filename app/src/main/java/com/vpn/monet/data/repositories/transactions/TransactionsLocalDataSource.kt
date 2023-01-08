package com.vpn.monet.data.repositories.transactions

import com.vpn.monet.domain.models.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionsLocalDataSource {
    suspend fun getTransactions(): Flow<List<Transaction>>
}