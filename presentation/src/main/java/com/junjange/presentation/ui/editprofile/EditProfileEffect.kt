package com.junjange.presentation.ui.editprofile

sealed class EditProfileEffect {
    data object LaunchImagePicker : EditProfileEffect()
}
