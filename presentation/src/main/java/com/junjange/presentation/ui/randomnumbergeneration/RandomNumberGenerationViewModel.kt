package com.junjange.presentation.ui.randomnumbergeneration

import com.junjange.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RandomNumberGenerationViewModel @Inject constructor() : BaseViewModel() {

    private val _uiState = MutableStateFlow(RandomNumberGenerationState())
    val uiState: StateFlow<RandomNumberGenerationState> = _uiState.asStateFlow()

}
