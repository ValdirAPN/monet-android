package com.vpn.monet.domain.models

import com.vpn.monet.data.entities.TransactionEntity
import com.vpn.monet.domain.models.enums.TransactionType
import java.util.Date

data class Transaction(
    val id: String,
    val title: String,
    val type: TransactionType,
    val value: Double,
    val installments: Int,
    val account: Account,
    val date: Date
)

fun Transaction.toEntity() = TransactionEntity(
    id = this.id,
    title = this.title,
    type = this.type,
    value = this.value,
    installments = this.installments,
    account = this.account.toEntity(),
    date = this.date
)