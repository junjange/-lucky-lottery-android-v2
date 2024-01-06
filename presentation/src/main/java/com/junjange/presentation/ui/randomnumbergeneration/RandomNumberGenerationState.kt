package com.junjange.presentation.ui.randomnumbergeneration


data class RandomNumberGenerationState(
    val isLoading: Boolean = false,
    val isLotto645: Boolean = true,
    val lotto645Number: List<Int> = listOf(0, 0, 0, 0, 0, 0),
    val lotto720Number: List<Int> = listOf(0, 0, 0, 0, 0, 0, 0),
)