package com.vpn.monet.data.repositories.transactions

import com.vpn.monet.data.db.TransactionDao
import com.vpn.monet.data.entities.TransactionEntity
import com.vpn.monet.data.entities.toDomainModel
import com.vpn.monet.domain.models.Transaction
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
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

    override fun insertTransaction(transactionEntity: TransactionEntity) {
        transactionDao.insert(transactionEntity)
    }
}