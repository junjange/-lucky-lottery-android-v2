package com.junjange.data.mapper

import com.junjange.data.model.KakaoAccessTokenResponse
import com.junjange.domain.model.KakaoAccessToken


internal fun KakaoAccessTokenResponse.toDomain(): KakaoAccessToken {
    return KakaoAccessToken(
        id_token = this.id_token,
        accessToken = this.accessToken
    )
}