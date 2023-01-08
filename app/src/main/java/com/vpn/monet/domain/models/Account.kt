package com.vpn.monet.domain.models

import com.vpn.monet.data.entities.AccountEntity
import com.vpn.monet.data.entities.TransactionEntity

data class Account(
    val id : Int? = null,
    val name: String,
) {
    override fun toString(): String {
        return "\nid: $id" +
                "\nname: $name"
    }
}

fun Account.toEntity() = AccountEntity(
    id = this.id,
    name = this.name
)