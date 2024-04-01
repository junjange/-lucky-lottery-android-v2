package com.junjange.domain.repository

import com.junjange.domain.model.ImageUpload
import okhttp3.MultipartBody

interface ImagesRepository {
    suspend fun postImagesUpload(file: MultipartBody.Part): Result<ImageUpload>
}
