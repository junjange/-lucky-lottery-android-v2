package com.junjange.domain.usecase

import com.junjange.domain.model.LotteryNumbers
import com.junjange.domain.repository.WinningRepository
import javax.inject.Inject

class GetLotteryHomeUseCase
    @Inject
    constructor(
        private val repository: WinningRepository,
    ) {
        suspend operator fun invoke(): Result<LotteryNumbers> = repository.getLotteryHome()
    }
