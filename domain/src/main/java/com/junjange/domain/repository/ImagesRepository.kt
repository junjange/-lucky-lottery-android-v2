package com.junjange.domain.repository

import com.junjange.domain.model.ImageUpload

interface ImagesRepository {
    suspend fun postImagesUpload(file: String): Result<ImageUpload>

}