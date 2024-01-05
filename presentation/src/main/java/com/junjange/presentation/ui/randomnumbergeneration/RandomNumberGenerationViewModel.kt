package com.junjange.presentation.ui.randomnumbergeneration

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import com.junjange.presentation.base.BaseViewModel
import com.junjange.presentation.component.LottoType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RandomNumberGenerationViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(RandomNumberGenerationState())
    val uiState: StateFlow<RandomNumberGenerationState> = _uiState.asStateFlow()

    init {
        savedStateHandle.get<String>(RandomNumberGenerationActivity.LOTTO_TYPE)?.let { lottoType ->
            _uiState.update { state ->
                state.copy(isLotto645 = lottoType == LottoType.LOTTO645.name)
            }
        } ?: run {
            // TODO : 예외 처리
        }
    }

}
