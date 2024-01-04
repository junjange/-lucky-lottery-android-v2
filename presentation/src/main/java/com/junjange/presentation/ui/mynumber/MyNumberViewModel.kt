package com.junjange.presentation.ui.mynumber

import com.junjange.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MyNumberViewModel @Inject constructor() : BaseViewModel() {

    private val _uiState = MutableStateFlow(MyNumberState())
    val uiState: StateFlow<MyNumberState> = _uiState.asStateFlow()

}
