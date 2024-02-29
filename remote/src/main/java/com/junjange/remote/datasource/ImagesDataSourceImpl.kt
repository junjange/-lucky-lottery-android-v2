package com.junjange.remote.datasource

import com.junjange.data.datasource.ImagesDataSource
import com.junjange.data.model.remote.ImageUploadEntity
import com.junjange.remote.api.ApiService
import com.junjange.remote.model.request.ImagesUploadRequest
import com.junjange.remote.model.response.toData
import javax.inject.Inject

internal class ImagesDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
) : ImagesDataSource {
    override suspend fun postImagesUpload(file: String): Result<ImageUploadEntity> = runCatching {
        val body = ImagesUploadRequest(file = file)
        apiService.postImagesUpload(body = body).data.toData()
    }
}