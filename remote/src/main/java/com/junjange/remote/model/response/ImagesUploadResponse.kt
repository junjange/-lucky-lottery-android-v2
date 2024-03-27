package com.junjange.remote.model.response

import com.junjange.data.model.remote.ImageUploadEntity

data class ImagesUploadResponse(
    val imageUrl: String,
)

fun ImagesUploadResponse.toData(): ImageUploadEntity = ImageUploadEntity(imageUrl = imageUrl)
