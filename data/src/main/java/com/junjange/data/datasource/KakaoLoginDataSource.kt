package com.junjange.data.datasource

import com.junjange.data.model.KakaoAccessTokenResponse


interface KakaoLoginDataSource {
    suspend fun login(): Result<KakaoAccessTokenResponse>
}
