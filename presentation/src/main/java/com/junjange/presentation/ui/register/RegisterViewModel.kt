package com.junjange.presentation.ui.register

import android.graphics.Bitmap
import androidx.lifecycle.SavedStateHandle
import com.junjange.domain.usecase.PostRegisterUseCase
import com.junjange.domain.usecase.SaveJwtTokenUseCase
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
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val postRegisterUseCase: PostRegisterUseCase,
    private val saveJwtTokenUseCase: SaveJwtTokenUseCase,
) : BaseViewModel() {

    private val idToken = requireNotNull(
        savedStateHandle.get<String>(RegisterActivity.EXTRA_KEY_ID_TOKEN)
    )
    private val provider = requireNotNull(
        savedStateHandle.get<String>(RegisterActivity.EXTRA_KEY_PROVIDER)
    )

    private val _uiState = MutableStateFlow(RegisterState())
    val uiState: StateFlow<RegisterState> = _uiState.asStateFlow()

    private val _effect = MutableSharedFlow<RegisterEffect>()
    val effect: SharedFlow<RegisterEffect> = _effect.asSharedFlow()

    fun onClickedBack() {
        launch {
            _effect.emit(Back)
        }
    }

    fun onClickedRegister() {
        launch {
            if (_uiState.value.newNickname.isNotEmpty()) {
                postRegisterUseCase(
                    idToken = idToken,
                    provider = provider,
                    nickName = _uiState.value.newNickname
                ).onSuccess { jwtToken ->
                    saveJwtTokenUseCase(jwtToken = jwtToken)
                        .onSuccess {
                            _effect.emit(NavigateToMain)
                        }.onFailure {
                            //TODO 예외 처리
                        }
                }.onFailure {
                    //TODO 예외 처리
                }
            }
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
        launch {
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