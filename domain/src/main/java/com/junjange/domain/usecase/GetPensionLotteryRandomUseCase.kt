package com.junjange.domain.usecase

import com.junjange.domain.model.PensionLotteryRandom
import com.junjange.domain.repository.PensionLotteryRepository
import javax.inject.Inject

class GetPensionLotteryRandomUseCase @Inject constructor(
    private val repository: PensionLotteryRepository
) {
    suspend operator fun invoke(): Result<PensionLotteryRandom> =
        repository.getPensionLotteryRandom()
}

