package com.vpn.monet.domain.usecases

import com.vpn.monet.data.entities.TransactionEntity
import com.vpn.monet.domain.repositories.TransactionsRepository
import javax.inject.Inject

class CreateTransactionsUseCase @Inject constructor(
    private val transactionsRepository: TransactionsRepository,
) {
    operator fun invoke(transactionEntity: TransactionEntity) =
        transactionsRepository.createTransaction(transactionEntity)
}