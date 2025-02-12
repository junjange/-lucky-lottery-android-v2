package com.junjange.data.di

import com.junjange.data.repository.CredentialRepositoryImpl
import com.junjange.data.repository.FirebaseRepositoryImpl
import com.junjange.data.repository.GoogleRepositoryImpl
import com.junjange.data.repository.ImagesRepositoryImpl
import com.junjange.data.repository.KakaoLoginRepositoryImpl
import com.junjange.data.repository.LocalRepositoryImpl
import com.junjange.data.repository.LotteryRepositoryImpl
import com.junjange.data.repository.NotificationRepositoryImpl
import com.junjange.data.repository.PensionLotteryRepositoryImpl
import com.junjange.data.repository.UserRepositoryImpl
import com.junjange.data.repository.WinningRepositoryImpl
import com.junjange.domain.repository.CredentialRepository
import com.junjange.domain.repository.FirebaseRepository
import com.junjange.domain.repository.GoogleRepository
import com.junjange.domain.repository.ImagesRepository
import com.junjange.domain.repository.KakaoLoginRepository
import com.junjange.domain.repository.LocalRepository
import com.junjange.domain.repository.LotteryRepository
import com.junjange.domain.repository.NotificationRepository
import com.junjange.domain.repository.PensionLotteryRepository
import com.junjange.domain.repository.UserRepository
import com.junjange.domain.repository.WinningRepository
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
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    @Singleton
    abstract fun bindLotteryRepository(lotteryRepositoryImpl: LotteryRepositoryImpl): LotteryRepository

    @Binds
    @Singleton
    abstract fun bindPensionLotteryRepository(pensionLotteryRepositoryImpl: PensionLotteryRepositoryImpl): PensionLotteryRepository

    @Binds
    @Singleton
    abstract fun bindWinningRepository(winningRepositoryImpl: WinningRepositoryImpl): WinningRepository

    @Binds
    @Singleton
    abstract fun bindNotificationRepository(notificationRepositoryImpl: NotificationRepositoryImpl): NotificationRepository

    @Binds
    @Singleton
    abstract fun bindImagesRepository(imagesRepositoryImpl: ImagesRepositoryImpl): ImagesRepository

    @Binds
    @Singleton
    abstract fun bindGoogleRepository(googleRepositoryImpl: GoogleRepositoryImpl): GoogleRepository
}
