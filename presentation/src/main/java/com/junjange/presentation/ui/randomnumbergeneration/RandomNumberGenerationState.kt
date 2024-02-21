package com.junjange.presentation.ui.randomnumbergeneration

import com.junjange.domain.model.LotteryRandomNumbers


data class RandomNumberGenerationState(
    val isLoading: Boolean = false,
    val isLotto645: Boolean = true,
    val lotteryRandomNumbers: LotteryRandomNumbers? = null,
    val lotto720Number: List<Int> = listOf(0, 0, 0, 0, 0, 0, 0),
)