package com.junjange.remote.datasource

import com.junjange.data.datasource.ImagesDataSource
import com.junjange.data.model.remote.ImageUploadEntity
import com.junjange.remote.api.ApiService
import com.junjange.remote.model.response.toData
import okhttp3.MultipartBody
import javax.inject.Inject

internal class ImagesDataSourceImpl
    @Inject
    constructor(
        private val apiService: ApiService,
    ) : ImagesDataSource {
        override suspend fun postImagesUpload(file: MultipartBody.Part): Result<ImageUploadEntity> =
            runCatching {
                apiService.postImagesUpload(file = file).data.toData()
            }
    }
