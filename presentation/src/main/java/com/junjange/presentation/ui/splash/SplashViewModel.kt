package com.junjange.presentation.ui.splash

import com.junjange.domain.usecase.GetJwtTokenUseCase
import com.junjange.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SplashViewModel
    @Inject
    constructor(
        private val getJwtTokenUseCase: GetJwtTokenUseCase,
    ) : BaseViewModel() {
        private val _uiState = MutableStateFlow(SplashState())
        val uiState: StateFlow<SplashState> = _uiState.asStateFlow()

        private val _effect = MutableSharedFlow<SplashEffect>()
        val effect: SharedFlow<SplashEffect> = _effect.asSharedFlow()

        init {
            launch {
                delay(SPLASH_TIME)
                getJwtTokenUseCase().onSuccess {
                    it?.let {
                        _effect.emit(SplashEffect.AlreadyLoggedIn)
                    } ?: run {
                        _effect.emit(SplashEffect.RequireLoginIn)
                    }
                }
            }
        }

        companion object {
            private const val SPLASH_TIME = 2000L
        }
    }
