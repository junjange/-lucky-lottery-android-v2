package com.junjange.domain.usecase

import com.junjange.domain.repository.PensionLotteryRepository
import javax.inject.Inject

class PostPensionLotterySaveUseCase @Inject constructor(
    private val repository: PensionLotteryRepository
) {
    suspend operator fun invoke(
        pensionGroup: Int,
        pensionFirstNum: Int,
        pensionSecondNum: Int,
        pensionThirdNum: Int,
        pensionFourthNum: Int,
        pensionFifthNum: Int,
        pensionSixthNum: Int
    ): Result<Unit> = repository.postPensionLotterySave(
        pensionGroup = pensionGroup,
        pensionFirstNum = pensionFirstNum,
        pensionSecondNum = pensionSecondNum,
        pensionThirdNum = pensionThirdNum,
        pensionFourthNum = pensionFourthNum,
        pensionFifthNum = pensionFifthNum,
        pensionSixthNum = pensionSixthNum
    )
}