package com.junjange.presentation.ui.mynumber

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.junjange.domain.usecase.GetLotteryGetUseCase
import com.junjange.domain.usecase.GetPensionLotteryGetUseCase
import com.junjange.presentation.base.BaseViewModel
import com.junjange.presentation.feature.ocr.OcrService
import com.junjange.presentation.ui.mynumber.MyNumberEffect.NavigateToGallery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.io.File
import javax.inject.Inject

@HiltViewModel
class MyNumberViewModel @Inject constructor(
    private val ocrService: OcrService,
    getPensionLotteryGetUseCase: GetPensionLotteryGetUseCase,
    getLotteryGetUseCase: GetLotteryGetUseCase

) : BaseViewModel() {

    private val _uiState = MutableStateFlow(MyNumberState())
    val uiState: StateFlow<MyNumberState> = _uiState.asStateFlow()

    private val _effect = MutableSharedFlow<MyNumberEffect>()
    val effect: SharedFlow<MyNumberEffect> = _effect.asSharedFlow()

    init {
        uiState.value.pensionLotteryGetContent =
            createPensionLotteryPagingSource(getPensionLotteryGetUseCase = getPensionLotteryGetUseCase).flow.cachedIn(
                viewModelScope
            )

        uiState.value.lotteryGetContent =
            createLotteryPagingSource(getLotteryGetUseCase = getLotteryGetUseCase).flow.cachedIn(
                viewModelScope
            )
    }

    fun onPickedImage() {
        launch {
            _effect.emit(NavigateToGallery)
        }
    }

    fun getTextOfImage(imagePath: String) {
        val text = ocrService.getTextOfImage(File(imagePath))

        val lottoNumbers = text.extractLottoNumbers()

        if (lottoNumbers.isValidLottoNumbers()) {
            _uiState.update { state ->
                state.copy(
                    tempList = state.tempList.addLottoNumbers(lottoNumbers = lottoNumbers)
                )
            }
        }
    }
}


private fun String.extractLottoNumbers(): List<List<String>> {
    return this.split("\n").map { it.split(" ") }
}

private fun List<List<String>>.isValidLottoNumbers(): Boolean {
    return all { lottoNumbers ->
        lottoNumbers.size == 6 && lottoNumbers.all { lottoNumber ->
            lottoNumber.toIntOrNull() != null && lottoNumber.length <= 2
        }
    }
}

private fun List<List<List<String>>>.addLottoNumbers(lottoNumbers: List<List<String>>): List<List<List<String>>> {
    return mapIndexed { index, ints ->
        if (index == 0) ints + lottoNumbers else ints
    }
}