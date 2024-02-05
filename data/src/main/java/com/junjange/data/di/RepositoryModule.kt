package com.junjange.data.di

import com.junjange.data.repository.CredentialRepositoryImpl
import com.junjange.data.repository.FirebaseRepositoryImpl
import com.junjange.data.repository.KakaoLoginRepositoryImpl
import com.junjange.data.repository.LocalRepositoryImpl
import com.junjange.data.repository.LotteryRepositoryImpl
import com.junjange.domain.repository.CredentialRepository
import com.junjange.domain.repository.FirebaseRepository
import com.junjange.domain.repository.KakaoLoginRepository
import com.junjange.domain.repository.LocalRepository
import com.junjange.domain.repository.LotteryRepository
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

    @Binds
    @Singleton
    abstract fun bindLocalRepository(localRepositoryImpl: LocalRepositoryImpl): LocalRepository

    @Binds
    @Singleton
    abstract fun bindCredentialRepository(credentialRepositoryImpl: CredentialRepositoryImpl): CredentialRepository

    @Binds
    @Singleton
    abstract fun bindLotteryRepository(lotteryRepositoryImpl: LotteryRepositoryImpl): LotteryRepository
}