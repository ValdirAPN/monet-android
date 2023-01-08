package com.vpn.monet.presentation.ui.transactionForm

import androidx.lifecycle.ViewModel
import com.vpn.monet.domain.models.Transaction
import com.vpn.monet.domain.models.toEntity
import com.vpn.monet.domain.usecases.CreateTransactionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TransactionFormViewModel @Inject constructor(
    private val createTransactionsUseCase: CreateTransactionsUseCase
) : ViewModel() {

    fun createTransaction(transaction: Transaction) {
        createTransactionsUseCase.invoke(transaction.toEntity())
    }
}