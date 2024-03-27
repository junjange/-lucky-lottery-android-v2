package com.junjange.presentation.ui.my

import com.junjange.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MyViewModel
    @Inject
    constructor() : BaseViewModel() {
        private val _uiState = MutableStateFlow(MyState())
        val uiState: StateFlow<MyState> = _uiState.asStateFlow()

        private val _effect = MutableSharedFlow<MyEffect>()
        val effect: SharedFlow<MyEffect> = _effect.asSharedFlow()

        fun onClickedNotification() {
            launch {
                _effect.emit(
                    MyEffect.NavigateToNotification(
                        lottoNotificationState = true,
                        pensionLottoNotificationState = false,
                    ),
                )
            }
        }

        fun onClickedEditProfile() {
            launch {
                _effect.emit(MyEffect.NavigateToEditProfile)
            }
        }

        fun onClickedUsageTerm() {
            launch {
                _effect.emit(MyEffect.NavigateToUsageTerm)
            }
        }

        fun onClickedSignOut() {
            launch {
                _effect.emit(MyEffect.NavigateToSplash)
            }
        }

        fun onClickedWithdrawal() {
            launch {
                _effect.emit(MyEffect.NavigateToWithdrawal)
            }
        }
    }
