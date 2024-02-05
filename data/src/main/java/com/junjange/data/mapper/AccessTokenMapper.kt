package com.junjange.data.mapper

import com.junjange.data.model.remote.AccessTokenEntity
import com.junjange.domain.model.AccessToken

internal fun AccessTokenEntity.toDomain(): AccessToken = AccessToken(accessToken = this.accessToken)