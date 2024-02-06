package com.junjange.presentation.ui.register

import android.graphics.Bitmap
import androidx.lifecycle.viewModelScope
import com.junjange.presentation.base.BaseViewModel
import com.junjange.presentation.ui.register.RegisterEffect.*
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
class RegisterViewModel @Inject constructor() : BaseViewModel() {

    private val _uiState = MutableStateFlow(RegisterState())
    val uiState: StateFlow<RegisterState> = _uiState.asStateFlow()

    private val _effect = MutableSharedFlow<RegisterEffect>()
    val effect: SharedFlow<RegisterEffect> = _effect.asSharedFlow()

    fun onClickedNavigateToMain() {
        viewModelScope.launch {
            _effect.emit(NavigateToMain)
        }
    }

    fun onClickedBack() {
        viewModelScope.launch {
            _effect.emit(Back)
        }
    }

    fun onPickImage(bitmap: Bitmap) {
        _uiState.update {
            it.copy(
                isBottomSheetShowing = false,
                newProfileImage = bitmap
            )
        }
    }

    fun inputNickname(value: String) {
        _uiState.update { it.copy(newNickname = value) }
    }

    fun setBottomSheetShowing(isBottomSheetShowing: Boolean) {
        _uiState.update { it.copy(isBottomSheetShowing = isBottomSheetShowing) }
    }

    fun onClickedProfileImgSelect() {
        viewModelScope.launch {
            _effect.emit(LaunchImagePicker)
        }
    }

    fun onClickedProfileDefaultImageSelect() {
        _uiState.update {
            it.copy(
                isBottomSheetShowing = false,
                newProfileImage = null
            )
        }
    }
}