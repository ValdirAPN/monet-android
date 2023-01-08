package com.vpn.monet.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.vpn.monet.data.entities.AccountEntity
import com.vpn.monet.data.entities.TransactionEntity
import com.vpn.monet.data.entities.converters.DateConverter

@Database(entities = [TransactionEntity::class, AccountEntity::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun accountDao(): AccountDao
}