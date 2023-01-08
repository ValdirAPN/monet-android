package com.vpn.monet.domain.models

import com.vpn.monet.data.entities.TransactionEntity
import com.vpn.monet.domain.models.enums.TransactionType
import java.util.Date

data class Transaction(
    val id: Int? = null,
    val title: String,
    val type: TransactionType,
    val thirdPerson: String,
    val value: Double,
    val installments: Int,
    val account: Account,
    val date: Date
) {
    override fun toString(): String {
        return "\nTitle: $title" +
                "\nType: $type" +
                "\nThirdPerson: $thirdPerson" +
                "\nValue: $value" +
                "\nImstallments: $installments" +
                "\nAccount: $account"
    }
}

fun Transaction.toEntity() = TransactionEntity(
    id = this.id,
    title = this.title,
    type = this.type,
    thirdPerson = this.thirdPerson,
    value = this.value,
    installments = this.installments,
    account = this.account.toEntity(),
    date = this.date
)