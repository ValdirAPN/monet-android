package com.vpn.monet.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vpn.monet.data.entities.AccountEntity
import com.vpn.monet.data.entities.TransactionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao {

    @Query("SELECT * FROM `account`")
    fun getAll() : Flow<List<AccountEntity>>

    @Insert
    fun insert(accountEntity: AccountEntity)
}