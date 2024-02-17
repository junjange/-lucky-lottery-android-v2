package com.junjange.domain.usecase

import com.junjange.domain.model.PensionLotteryHome
import com.junjange.domain.repository.PensionLotteryRepository
import javax.inject.Inject

class GetPensionLotteryHomeUseCase @Inject constructor(
    private val repository: PensionLotteryRepository
) {
    suspend operator fun invoke(): Result<PensionLotteryHome> = repository.getPensionLotteryHome()
}