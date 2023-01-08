package com.vpn.monet.di

import com.vpn.monet.data.repositories.TransactionsRepositoryImpl
import com.vpn.monet.domain.repositories.TransactionsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModules {

    @Binds
    abstract fun bindTransactionRepositoryImpl(impl: TransactionsRepositoryImpl): TransactionsRepository
}