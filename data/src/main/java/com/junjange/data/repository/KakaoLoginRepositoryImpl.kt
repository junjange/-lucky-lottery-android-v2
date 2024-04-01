package com.junjange.data.repository

import com.junjange.data.datasource.KakaoLoginDataSource
import com.junjange.data.mapper.toDomain
import com.junjange.domain.model.KakaoAccessToken
import com.junjange.domain.repository.KakaoLoginRepository
import javax.inject.Inject

internal class KakaoLoginRepositoryImpl
    @Inject
    constructor(
        private val kakaoLoginDataSource: KakaoLoginDataSource,
    ) : KakaoLoginRepository {
        override suspend fun login(): Result<KakaoAccessToken> = kakaoLoginDataSource.login().mapCatching { it.toDomain() }
    }
