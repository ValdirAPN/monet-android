package com.vpn.monet.domain.repositories

import com.vpn.monet.domain.models.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionsRepository {
    suspend fun getTransactions() : Flow<List<Transaction>>
}