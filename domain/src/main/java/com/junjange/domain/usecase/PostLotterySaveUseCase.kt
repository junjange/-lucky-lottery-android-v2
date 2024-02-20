package com.junjange.domain.usecase

import com.junjange.domain.repository.LotteryRepository
import javax.inject.Inject

class PostLotterySaveUseCase @Inject constructor(
    private val repository: LotteryRepository
) {
    suspend operator fun invoke(
        firstNum: Int,
        secondNum: Int,
        thirdNum: Int,
        fourthNum: Int,
        fifthNum: Int,
        sixthNum: Int,
    ): Result<Unit> = repository.postLotterySave(
        firstNum = firstNum,
        secondNum = secondNum,
        thirdNum = thirdNum,
        fourthNum = fourthNum,
        fifthNum = fifthNum,
        sixthNum = sixthNum,
    )
}