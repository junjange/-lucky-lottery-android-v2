package com.junjange.data.datasource

import com.junjange.data.model.remote.ImageUploadEntity
import okhttp3.MultipartBody

interface ImagesDataSource {
    suspend fun postImagesUpload(file: MultipartBody.Part): Result<ImageUploadEntity>
}
