package com.junjange.data.repository

import com.junjange.data.datasource.ImagesDataSource
import com.junjange.data.mapper.toDomain
import com.junjange.domain.model.ImageUpload
import com.junjange.domain.repository.ImagesRepository
import okhttp3.MultipartBody
import javax.inject.Inject

internal class ImagesRepositoryImpl
    @Inject
    constructor(
        private val imagesDataSource: ImagesDataSource,
    ) : ImagesRepository {
        override suspend fun postImagesUpload(file: MultipartBody.Part): Result<ImageUpload> =
            imagesDataSource.postImagesUpload(file = file).mapCatching { it.toDomain() }
    }
