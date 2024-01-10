package com.junjange.presentation.ui.login

import androidx.lifecycle.viewModelScope
import com.junjange.domain.usecase.KakaoLoginUseCase
import com.junjange.presentation.base.BaseViewModel
import com.junjange.presentation.ui.login.LoginEffect.NavigateToMain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val kakaoLoginUseCase: KakaoLoginUseCase
) : BaseViewModel() {
    private val _uiState = MutableStateFlow(LoginState())
    val uiState: StateFlow<LoginState> = _uiState.asStateFlow()

    private val _effect = MutableSharedFlow<LoginEffect>()
    val effect: SharedFlow<LoginEffect> = _effect.asSharedFlow()

    fun kakaoLogin() {
        viewModelScope.launch {
            kakaoLoginUseCase().onSuccess {
                _effect.emit(NavigateToMain)
            }.onFailure { }
        }
    }

}