package com.junjange.presentation.ui.editprofile

import android.graphics.Bitmap


data class EditProfileState(
    val isLoading: Boolean = false,
    val isNotificationAvailable: Boolean = false,
    val isEditMode: Boolean = false,
    val newNickname: String = "",
    val currentNickName: String = "",
    val newProfileImage: Bitmap? = null,
    val isBottomSheetShowing: Boolean = false,
)