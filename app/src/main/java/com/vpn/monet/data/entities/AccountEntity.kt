package com.vpn.monet.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vpn.monet.domain.models.Account
import com.vpn.monet.domain.models.Transaction

@Entity(tableName = "account")
data class AccountEntity(
    @PrimaryKey
    val id: String,
    val name: String,
)

fun AccountEntity.toDomainModel() : Account {
    return Account(
        id = this.id,
        name = this.name
    )
}

