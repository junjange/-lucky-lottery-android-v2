package com.junjange.domain.usecase

import com.junjange.domain.model.UserMyInfo
import com.junjange.domain.repository.UserRepository
import javax.inject.Inject

class GetUserMyInfoUseCase
    @Inject
    constructor(
        private val repository: UserRepository,
    ) {
        suspend operator fun invoke(): Result<UserMyInfo> = repository.getUserMyInfo()
    }
