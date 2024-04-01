package com.junjange.domain.repository

import com.junjange.domain.model.KakaoAccessToken

interface KakaoLoginRepository {
    suspend fun login(): Result<KakaoAccessToken>
}
