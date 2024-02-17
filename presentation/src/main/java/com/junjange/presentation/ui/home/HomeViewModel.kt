package com.junjange.presentation.ui.home

import android.util.Log
import com.junjange.domain.model.PensionLotteryHome
import com.junjange.domain.usecase.GetLotteryHomeUseCase
import com.junjange.domain.usecase.GetPensionLotteryHomeUseCase
import com.junjange.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getLotteryHomeUseCase: GetLotteryHomeUseCase,
    private val getPensionLotteryHomeUseCase: GetPensionLotteryHomeUseCase,
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(HomeState())
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()

    init {
        getLotteryHome()
        getPensionLotteryHome()
    }

    private fun getLotteryHome() {
        launch {
            getLotteryHomeUseCase().onSuccess {
                _uiState.update { homeState ->
                    homeState.copy(lotteryNumbers = it)
                }
            }.onFailure {
                // TODO 예외처리
            }
        }
    }

    private fun getPensionLotteryHome() {
        launch {
            getPensionLotteryHomeUseCase().onSuccess {
                _uiState.update { homeState ->
                    homeState.copy(pensionLotteryHome = it)
                }
            }.onFailure {
                // TODO 예외처리
            }
        }
    }

}
