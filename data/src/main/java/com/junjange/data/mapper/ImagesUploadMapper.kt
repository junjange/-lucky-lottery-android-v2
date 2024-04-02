package com.junjange.data.mapper

import com.junjange.data.model.remote.ImageUploadEntity
import com.junjange.domain.model.ImageUpload

internal fun ImageUploadEntity.toDomain(): ImageUpload = ImageUpload(imageUrl = imageUrl)
