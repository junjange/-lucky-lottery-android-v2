package com.junjange.presentation.ui.randomnumber

import com.junjange.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RandomNumberViewModel
    @Inject
    constructor() : BaseViewModel() {
        private val _uiState = MutableStateFlow(RandomNumberState())
        val uiState: StateFlow<RandomNumberState> = _uiState.asStateFlow()
    }
