package com.junjange.remote.di

import com.junjange.data.datasource.CredentialDataSource
import com.junjange.data.datasource.ImagesDataSource
import com.junjange.data.datasource.LotteryDataSource
import com.junjange.data.datasource.NotificationDataSource
import com.junjange.data.datasource.PensionLotteryDataSource
import com.junjange.data.datasource.UserDataSource
import com.junjange.data.datasource.WinningDataSource
import com.junjange.remote.datasource.CredentialDataSourceImpl
import com.junjange.remote.datasource.ImagesDataSourceImpl
import com.junjange.remote.datasource.LotteryDataSourceImpl
import com.junjange.remote.datasource.NotificationDataSourceImpl
import com.junjange.remote.datasource.PensionLotteryDataSourceImpl
import com.junjange.remote.datasource.UserDataSourceImpl
import com.junjange.remote.datasource.WinningDataSourceImpl
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
    abstract fun bindsUserDataSource(userDataSourceImpl: UserDataSourceImpl): UserDataSource

    @Binds
    abstract fun bindsLotteryDataSource(lotteryDataSourceImpl: LotteryDataSourceImpl): LotteryDataSource

    @Binds
    abstract fun bindsPensionLotteryDataSource(pensionLotteryDataSourceImpl: PensionLotteryDataSourceImpl): PensionLotteryDataSource

    @Binds
    abstract fun bindsWinningDataSource(winningDataSourceImpl: WinningDataSourceImpl): WinningDataSource

    @Binds
    abstract fun bindsNotificationDataSource(notificationDataSourceImpl: NotificationDataSourceImpl): NotificationDataSource

    @Binds
    abstract fun bindsImagesDataSource(imagesDataSourceImpl: ImagesDataSourceImpl): ImagesDataSource
}
