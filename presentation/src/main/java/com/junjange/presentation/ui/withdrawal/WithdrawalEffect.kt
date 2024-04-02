package com.junjange.presentation.ui.withdrawal

sealed class WithdrawalEffect {
    data object AddStep : WithdrawalEffect()
}
