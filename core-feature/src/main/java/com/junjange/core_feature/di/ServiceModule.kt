package com.junjange.core_feature.di

import com.junjange.core_feature.ocr.OcrServiceImpl
import com.junjange.presentation.feature.ocr.OcrService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface ServiceModule {

    @Binds
    @Singleton
    fun bindOcrService(service: OcrServiceImpl): OcrService

}
