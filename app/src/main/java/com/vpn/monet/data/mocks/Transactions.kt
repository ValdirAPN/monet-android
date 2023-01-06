package com.vpn.monet.data.mocks

import com.vpn.monet.domain.models.Account
import com.vpn.monet.domain.models.Transaction
import com.vpn.monet.domain.models.enums.TransactionType
import java.util.Date

val ACCOUNTS_MOCK = listOf(
    Account("Nubank"),
    Account("Will"),
    Account("Inter")
)

val TRANSCATIONS_MOCK = listOf(
    Transaction("Gasolina", TransactionType.OUTCOME, 100.00, 1, ACCOUNTS_MOCK[0], Date()),
    Transaction("Salário", TransactionType.INCOME, 5500.00, 1, ACCOUNTS_MOCK[0], Date()),
    Transaction("Lanche", TransactionType.OUTCOME, 64.00, 1, ACCOUNTS_MOCK[0], Date()),
)