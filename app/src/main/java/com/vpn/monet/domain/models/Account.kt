package com.vpn.monet.domain.models

import com.vpn.monet.data.entities.AccountEntity
import com.vpn.monet.data.entities.TransactionEntity

data class Account(
    val id : String,
    val name: String,
)

fun Account.toEntity() = AccountEntity(
    id = this.id,
    name = this.name
)