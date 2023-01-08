package com.vpn.monet.di

import com.vpn.monet.data.repositories.transactions.TransactionsLocalDataSource
import com.vpn.monet.data.repositories.transactions.TransactionsLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DatasourceModules {

    @Binds
    abstract fun bindTransactionsLocalDataSourceImpl(impl: TransactionsLocalDataSourceImpl): TransactionsLocalDataSource
}