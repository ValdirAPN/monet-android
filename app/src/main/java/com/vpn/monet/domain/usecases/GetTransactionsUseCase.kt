package com.vpn.monet.domain.usecases

import com.vpn.monet.domain.repositories.TransactionsRepository
import javax.inject.Inject

class GetTransactionsUseCase @Inject constructor(
    private val transactionsRepository: TransactionsRepository,
) {
    suspend operator fun invoke() =
        transactionsRepository.getTransactions()
}