package com.junjange.domain.usecase

import com.junjange.domain.model.PensionLotteryGet
import com.junjange.domain.repository.PensionLotteryRepository
import javax.inject.Inject

class GetPensionLotteryGetUseCase @Inject constructor(
    private val repository: PensionLotteryRepository
) {
    suspend operator fun invoke(
        page: Int,
        size: Int
    ): Result<PensionLotteryGet> =
        repository.getPensionLotteryGet(
            page = page,
            size = size
        )
}