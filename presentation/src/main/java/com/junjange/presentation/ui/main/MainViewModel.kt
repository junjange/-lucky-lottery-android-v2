package com.junjange.presentation.ui.main

import com.junjange.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel
    @Inject
    constructor() : BaseViewModel() {
        private val _uiState = MutableStateFlow(MainState())
        val uiState: StateFlow<MainState> = _uiState.asStateFlow()
    }
