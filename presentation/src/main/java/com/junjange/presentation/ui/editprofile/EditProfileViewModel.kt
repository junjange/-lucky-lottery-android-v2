package com.junjange.presentation.ui.editprofile

import android.graphics.Bitmap
import androidx.lifecycle.viewModelScope
import com.junjange.domain.usecase.ImagesUploadUseCase
import com.junjange.domain.usecase.PatchUserProfileUseCase
import com.junjange.presentation.base.BaseViewModel
import com.junjange.presentation.ui.editprofile.EditProfileEffect.LaunchImagePicker
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
class EditProfileViewModel
    @Inject
    constructor(
        private val patchUserProfileUseCase: PatchUserProfileUseCase,
        private val postImagesUploadUseCase: ImagesUploadUseCase,
    ) : BaseViewModel() {
        private val _uiState = MutableStateFlow(EditProfileState())
        val uiState: StateFlow<EditProfileState> = _uiState.asStateFlow()

        private val _effect = MutableSharedFlow<EditProfileEffect>()
        val effect: SharedFlow<EditProfileEffect> = _effect.asSharedFlow()

        init {
            // TODO 임시 데이터
            _uiState.update {
                it.copy(
                    currentNickName = "조준장",
                    newNickname = "조준장",
                )
            }
        }

        fun patchUserProfile() {
            launch {
                _uiState.value.newProfileImage?.let {
//                patchUserProfileUseCase(it).onSuccess { }.onFailure { }
                }
            }
        }

        fun onPickImage(bitmap: Bitmap) {
            _uiState.update {
                it.copy(
                    isBottomSheetShowing = false,
                    newProfileImage = bitmap,
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
                    newProfileImage = null,
                )
            }
        }
    }
