package com.junjange.firebase.di

import com.junjange.data.datasource.FirebaseDataSource
import com.junjange.data.datasource.GoogleDataSource
import com.junjange.firebase.datasource.FirebaseDataSourceImpl
import com.junjange.firebase.datasource.GoogleDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindFirebaseDataSource(firebaseDataSourceImpl: FirebaseDataSourceImpl): FirebaseDataSource

    @Binds
    @Singleton
    abstract fun bindGoogleDataSource(googleDataSourceImpl: GoogleDataSourceImpl): GoogleDataSource
}
