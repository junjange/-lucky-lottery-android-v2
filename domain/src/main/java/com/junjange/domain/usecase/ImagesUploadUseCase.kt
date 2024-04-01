package com.junjange.domain.usecase

import com.junjange.domain.model.ImageUpload
import com.junjange.domain.repository.ImagesRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class ImagesUploadUseCase
    @Inject
    constructor(
        private val repository: ImagesRepository,
    ) {
        suspend operator fun invoke(file: MultipartBody.Part): Result<ImageUpload> = repository.postImagesUpload(file = file)
    }
