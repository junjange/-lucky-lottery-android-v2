package com.junjange.data.datasource

import com.junjange.data.model.remote.ImageUploadEntity

interface ImagesDataSource {
    suspend fun postImagesUpload(file: String): Result<ImageUploadEntity>
}
