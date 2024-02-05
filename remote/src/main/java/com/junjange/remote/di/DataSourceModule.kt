package com.junjange.remote.di

import com.junjange.data.datasource.CredentialDataSource
import com.junjange.remote.datasource.CredentialDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {

    @Binds
    abstract fun bindsCredentialDataSource(credentialDataSourceImpl: CredentialDataSourceImpl): CredentialDataSource

}
