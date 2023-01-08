package com.vpn.monet.data.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vpn.monet.domain.models.Account
import com.vpn.monet.domain.models.Transaction
import com.vpn.monet.domain.models.enums.TransactionType
import java.util.*

@Entity(tableName = "transaction")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String,
    val type: TransactionType,
    val thirdPerson: String,
    val value: Double,
    val installments: Int,
    @Embedded(prefix = "account_")
    val account: AccountEntity,
    val date: Date
)

fun TransactionEntity.toDomainModel() : Transaction {
    return Transaction(
        id = this.id,
        title = this.title,
        type = this.type,
        thirdPerson = this.thirdPerson,
        value = this.value,
        installments = this.installments,
        account = this.account.toDomainModel(),
        date = this.date
    )
}