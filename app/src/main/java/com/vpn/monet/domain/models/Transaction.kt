package com.vpn.monet.domain.models

import com.vpn.monet.domain.models.enums.TransactionType
import java.util.Date

data class Transaction(
    private val title: String,
    private val type: TransactionType,
    private val value: Double,
    private val installments: Int,
    private val account: Account,
    private val date: Date
)
