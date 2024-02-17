package com.junjange.presentation.ui.home

import com.junjange.domain.model.LotteryNumbers
import com.junjange.domain.model.PensionLotteryHome


data class HomeState(
    val isLoading: Boolean = false,
    val lotteryNumbers: LotteryNumbers? = null,
    val pensionLotteryHome: PensionLotteryHome? = null,
)