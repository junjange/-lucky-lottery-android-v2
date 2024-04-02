package com.junjange.local.di

import com.junjange.data.datasource.LocalDataSource
import com.junjange.local.datasource.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {
    @Binds
    abstract fun bindsLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource
}
