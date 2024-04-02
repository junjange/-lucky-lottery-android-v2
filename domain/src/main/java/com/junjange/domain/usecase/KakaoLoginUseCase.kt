package com.junjange.domain.usecase

import com.junjange.domain.model.KakaoAccessToken
import com.junjange.domain.repository.KakaoLoginRepository
import javax.inject.Inject

class KakaoLoginUseCase
    @Inject
    constructor(
        private val kakaoLoginRepository: KakaoLoginRepository,
    ) {
        suspend operator fun invoke(): Result<KakaoAccessToken> = kakaoLoginRepository.login()
    }
