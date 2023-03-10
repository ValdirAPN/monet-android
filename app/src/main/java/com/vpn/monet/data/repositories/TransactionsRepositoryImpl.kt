package com.vpn.monet.data.repositories

import com.vpn.monet.data.entities.TransactionEntity
import com.vpn.monet.data.repositories.transactions.TransactionsLocalDataSource
import com.vpn.monet.domain.common.Result
import com.vpn.monet.domain.models.Transaction
import com.vpn.monet.domain.repositories.TransactionsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransactionsRepositoryImpl @Inject constructor(
    private val localDataSource: TransactionsLocalDataSource
) : TransactionsRepository {
    override suspend fun getTransactions() = localDataSource.getTransactions()

    override suspend fun getIncomeTransactions() = localDataSource.getIncomeTransactions()

    override suspend fun getOutcomeTransactions() = localDataSource.getOutcomeTransactions()

    override fun createTransaction(transactionEntity: TransactionEntity) {
        localDataSource.insertTransaction(transactionEntity)
    }
}