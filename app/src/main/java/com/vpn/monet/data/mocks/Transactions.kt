package com.vpn.monet.data.mocks

import com.vpn.monet.domain.models.Account
import com.vpn.monet.domain.models.Transaction
import com.vpn.monet.domain.models.enums.TransactionType
import java.util.Date

val ACCOUNTS_MOCK = listOf(
    Account(1,"Nubank"),
    Account(2,"Will"),
    Account(3,"Inter")
)

val TRANSCATIONS_MOCK = listOf(
    Transaction(1,"Gasolina", TransactionType.OUTCOME, "Posto Fan",100.00, 1, ACCOUNTS_MOCK[0], Date()),
    Transaction(2,"Salário", TransactionType.INCOME, "MobApps", 5500.00, 1, ACCOUNTS_MOCK[0], Date()),
    Transaction(3,"Lanche", TransactionType.OUTCOME, "Hot'n Tender", 64.00, 1, ACCOUNTS_MOCK[0], Date()),
)