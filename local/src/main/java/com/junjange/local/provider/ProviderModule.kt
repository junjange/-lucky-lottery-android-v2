package com.junjange.local.provider

import com.junjange.data.provider.AccessTokenProvider
import com.junjange.data.provider.RefreshTokenProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ProviderModule {
    @Binds
    abstract fun provideAccessTokenProvider(provider: AccessTokenProviderImpl): AccessTokenProvider

    @Binds
    abstract fun provideRefreshTokenProvider(provider: RefreshTokenProviderImpl): RefreshTokenProvider
}
