package com.junjange.kakao.di

import com.junjange.data.datasource.KakaoLoginDataSource
import com.junjange.kakao.datasource.KakaoLoginDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {

    @Binds
    abstract fun bindsKakaoLoginDataSource(kakaoLoginDataSourceImpl: KakaoLoginDataSourceImpl): KakaoLoginDataSource
}
