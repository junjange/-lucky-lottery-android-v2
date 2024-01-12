package com.junjange.data.di

import com.junjange.data.repository.FirebaseRepositoryImpl
import com.junjange.data.repository.KakaoLoginRepositoryImpl
import com.junjange.domain.repository.FirebaseRepository
import com.junjange.domain.repository.KakaoLoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindKakaoLoginRepository(kakaoLoginRepositoryImpl: KakaoLoginRepositoryImpl): KakaoLoginRepository

    @Binds
    @Singleton
    abstract fun bindFirebaseRepository(firebaseRepositoryImpl: FirebaseRepositoryImpl): FirebaseRepository
}