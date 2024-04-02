package com.junjange.data.datasource

import com.junjange.data.model.local.KakaoAccessTokenEntity

interface KakaoLoginDataSource {
    suspend fun login(): Result<KakaoAccessTokenEntity>
}
