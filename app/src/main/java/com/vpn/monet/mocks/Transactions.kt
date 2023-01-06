package com.vpn.monet.mocks

import com.vpn.monet.models.Account
import com.vpn.monet.models.Transaction
import com.vpn.monet.models.enums.TransactionType
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