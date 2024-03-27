package com.junjange.domain.usecase

import com.junjange.domain.model.PensionLotteryHome
import com.junjange.domain.repository.WinningRepository
import javax.inject.Inject

class GetPensionLotteryHomeUseCase
    @Inject
    constructor(
        private val repository: WinningRepository,
    ) {
        suspend operator fun invoke(): Result<PensionLotteryHome> = repository.getPensionLotteryHome()
    }
