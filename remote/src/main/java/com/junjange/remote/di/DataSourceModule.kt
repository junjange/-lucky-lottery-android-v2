package com.junjange.remote.di

import com.junjange.data.datasource.CredentialDataSource
import com.junjange.data.datasource.LotteryDataSource
import com.junjange.data.datasource.PensionLotteryDataSource
import com.junjange.remote.datasource.CredentialDataSourceImpl
import com.junjange.remote.datasource.LotteryDataSourceImpl
import com.junjange.remote.datasource.PensionLotteryDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {

    @Binds
    abstract fun bindsCredentialDataSource(credentialDataSourceImpl: CredentialDataSourceImpl): CredentialDataSource

    @Binds
    abstract fun bindsLotteryDataSource(lotteryDataSourceImpl: LotteryDataSourceImpl): LotteryDataSource

    @Binds
    abstract fun bindsPensionLotteryDataSource(pensionLotteryDataSourceImpl: PensionLotteryDataSourceImpl): PensionLotteryDataSource

}
