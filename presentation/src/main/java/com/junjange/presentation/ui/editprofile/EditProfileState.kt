package com.junjange.presentation.ui.editprofile

import android.graphics.Bitmap
import okhttp3.MultipartBody

data class EditProfileState(
    val isLoading: Boolean = false,
    val isNotificationAvailable: Boolean = false,
    val isEditMode: Boolean = false,
    val newNickname: String = "",
    val currentNickName: String = "",
    val profilePath: MultipartBody.Part? = null,
    val currentProfileImage: String? = null,
    val newProfileImage: String? = null,
    val newProfileImageBitmap: Bitmap? = null,
    val isBottomSheetShowing: Boolean = false,
)
