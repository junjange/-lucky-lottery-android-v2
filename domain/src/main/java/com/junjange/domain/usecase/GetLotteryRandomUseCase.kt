package com.junjange.domain.usecase

import com.junjange.domain.model.LotteryRandomNumbers
import com.junjange.domain.repository.LotteryRepository
import javax.inject.Inject

class GetLotteryRandomUseCase @Inject constructor(
    private val repository: LotteryRepository
) {
    suspend operator fun invoke(): Result<LotteryRandomNumbers> = repository.getLotteryRandom()
}

