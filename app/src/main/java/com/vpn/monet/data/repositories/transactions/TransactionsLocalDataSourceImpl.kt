package com.vpn.monet.data.repositories.transactions

import com.vpn.monet.data.db.TransactionDao
import com.vpn.monet.data.entities.TransactionEntity
import com.vpn.monet.data.entities.toDomainModel
import com.vpn.monet.domain.models.Transaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TransactionsLocalDataSourceImpl @Inject constructor(
    private val transactionDao: TransactionDao
): TransactionsLocalDataSource {
    override suspend fun getTransactions() : Flow<List<Transaction>> {
        val transactionsFlow = transactionDao.getAll()
        return transactionsFlow.map { list ->
            list.map {
                it.toDomainModel()
            }
        }
    }

    override suspend fun getIncomeTransactions(): Flow<List<Transaction>> {
        val transactionsFlow = transactionDao.getAllIncomes()
        return transactionsFlow.map { list ->
            list.map {
                it.toDomainModel()
            }
        }
    }

    override suspend fun getOutcomeTransactions(): Flow<List<Transaction>> {
        val transactionsFlow = transactionDao.getAllOutcomes()
        return transactionsFlow.map { list ->
            list.map {
                it.toDomainModel()
            }
        }
    }

    override fun insertTransaction(transactionEntity: TransactionEntity) {
        transactionDao.insert(transactionEntity)
    }
}