package com.junjange.data.repository

import com.junjange.data.datasource.ImagesDataSource
import com.junjange.data.mapper.toDomain
import com.junjange.domain.model.ImageUpload
import com.junjange.domain.repository.ImagesRepository
import javax.inject.Inject

internal class ImagesRepositoryImpl @Inject constructor(
    private val imagesDataSource: ImagesDataSource
) : ImagesRepository {
    override suspend fun postImagesUpload(file: String): Result<ImageUpload> =
        imagesDataSource.postImagesUpload(file = file).mapCatching { it.toDomain() }

}