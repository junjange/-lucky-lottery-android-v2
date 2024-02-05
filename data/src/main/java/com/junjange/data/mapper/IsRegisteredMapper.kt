package com.junjange.data.mapper

import com.junjange.data.model.remote.IsRegisteredEntity
import com.junjange.domain.model.IsRegistered

internal fun IsRegisteredEntity.toDomain(): IsRegistered = IsRegistered(isRegistered = this.isRegistered)