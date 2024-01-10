package com.junjange.presentation.ui.login


data class LoginState(
    val isLoading: Boolean = false,
)

sealed class LoginEffect {
    data object NavigateToMain : LoginEffect()
}
