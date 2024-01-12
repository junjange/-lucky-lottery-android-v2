package com.junjange.data.mapper

import com.junjange.data.model.local.KakaoAccessTokenEntity
import com.junjange.domain.model.KakaoAccessToken


internal fun KakaoAccessTokenEntity.toDomain(): KakaoAccessToken {
    return KakaoAccessToken(
        id_token = this.idToken,
        accessToken = this.accessToken
    )
}