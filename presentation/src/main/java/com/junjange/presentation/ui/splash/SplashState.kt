package com.junjange.presentation.ui.splash


data class SplashState(
    val isLoading: Boolean = false
)

sealed class SplashEffect {
    data object Loading : SplashEffect()
    data object AlreadyLoggedIn : SplashEffect()
    data object RequireLoginIn : SplashEffect()
}