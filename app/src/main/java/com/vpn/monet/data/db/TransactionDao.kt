package com.vpn.monet.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vpn.monet.data.entities.TransactionEntity
import com.vpn.monet.domain.models.enums.TransactionType
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    @Query("SELECT * FROM `transaction`")
    fun getAll() : Flow<List<TransactionEntity>>

    @Query("SELECT * FROM `transaction` WHERE type = 'INCOME'")
    fun getAllIncomes() : Flow<List<TransactionEntity>>

    @Query("SELECT * FROM `transaction` WHERE type = 'OUTCOME'")
    fun getAllOutcomes() : Flow<List<TransactionEntity>>

    @Insert
    fun insert(transactionEntity: TransactionEntity)
}