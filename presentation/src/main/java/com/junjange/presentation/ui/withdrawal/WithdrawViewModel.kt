package com.junjange.presentation.ui.withdrawal

import com.junjange.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class WithdrawViewModel @Inject constructor() : BaseViewModel() {

    private val _uiState = MutableStateFlow(WithdrawalState())
    val uiState: StateFlow<WithdrawalState> = _uiState.asStateFlow()

    fun addStep(step: Int) {
        _uiState.update { state ->
            state.copy(step = state.step + step)
        }
    }

    fun onClickedDialog(isWithdrawalDialogShowing: Boolean) {
        _uiState.update { state ->
            state.copy(isWithdrawalDialogShowing = isWithdrawalDialogShowing)
        }
    }
}
