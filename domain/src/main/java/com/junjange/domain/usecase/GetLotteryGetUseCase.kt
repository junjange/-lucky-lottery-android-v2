package com.junjange.domain.usecase

import com.junjange.domain.model.LotteryGet
import com.junjange.domain.repository.LotteryRepository
import javax.inject.Inject

class GetLotteryGetUseCase @Inject constructor(
    private val repository: LotteryRepository
) {
    suspend operator fun invoke(
        page: Int,
        size: Int
    ): Result<LotteryGet> =
        repository.getLotteryGet(
            page = page,
            size = size
        )
}