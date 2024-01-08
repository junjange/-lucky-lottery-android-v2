package com.junjange.presentation.ui.my

import androidx.lifecycle.viewModelScope
import com.junjange.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor() : BaseViewModel() {

    private val _uiState = MutableStateFlow(MyState())
    val uiState: StateFlow<MyState> = _uiState.asStateFlow()

    private val _effect = MutableSharedFlow<MyEffect>()
    val effect: SharedFlow<MyEffect> = _effect.asSharedFlow()

    fun setNotification(enabled: Boolean) {
        _uiState.update { it.copy(isNotificationAvailable = enabled) }
    }

    fun onClickedEditProfile() {
        viewModelScope.launch {
            _effect.emit(MyEffect.NavigateToEditProfile)
        }
    }

    fun onClickedUsageTerm(){
        viewModelScope.launch {
            _effect.emit(MyEffect.NavigateToUsageTerm)
        }
    }

    fun onClickedSignOut(){
        viewModelScope.launch {
            _effect.emit(MyEffect.NavigateToSplash)
        }
    }

    fun onClickedWithdrawal(){
        viewModelScope.launch {
            _effect.emit(MyEffect.NavigateToWithdrawal)
        }
    }
}
