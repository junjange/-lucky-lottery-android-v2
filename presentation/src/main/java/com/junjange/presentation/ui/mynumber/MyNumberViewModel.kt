package com.junjange.presentation.ui.mynumber

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.junjange.domain.usecase.GetLotteryGetUseCase
import com.junjange.domain.usecase.GetPensionLotteryGetUseCase
import com.junjange.domain.usecase.PostLotterySaveUseCase
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
    private val getPensionLotteryGetUseCase: GetPensionLotteryGetUseCase,
    private val getLotteryGetUseCase: GetLotteryGetUseCase,
    private val postLotterySaveUseCase: PostLotterySaveUseCase,
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(MyNumberState())
    val uiState: StateFlow<MyNumberState> = _uiState.asStateFlow()

    private val _effect = MutableSharedFlow<MyNumberEffect>()
    val effect: SharedFlow<MyNumberEffect> = _effect.asSharedFlow()

    init {
        getLotteryGet()
        getPensionLotteryGet()
    }

    private fun getLotteryGet() {
        uiState.value.lotteryGetContent =
            createLotteryPagingSource(getLotteryGetUseCase = getLotteryGetUseCase).flow.cachedIn(
                viewModelScope
            )
    }

    private fun getPensionLotteryGet() {
        uiState.value.pensionLotteryGetContent =
            createPensionLotteryPagingSource(getPensionLotteryGetUseCase = getPensionLotteryGetUseCase).flow.cachedIn(
                viewModelScope
            )
    }

    private fun loading(isLoading: Boolean) {
        _uiState.update { state ->
            state.copy(isLoading = isLoading)
        }
    }

    private fun postLotterySave(
        firstNum: Int,
        secondNum: Int,
        thirdNum: Int,
        fourthNum: Int,
        fifthNum: Int,
        sixthNum: Int,
    ) {
        launch {
            loading(isLoading = true)
            postLotterySaveUseCase(
                firstNum = firstNum,
                secondNum = secondNum,
                thirdNum = thirdNum,
                fourthNum = fourthNum,
                fifthNum = fifthNum,
                sixthNum = sixthNum,
            ).onSuccess {
                loading(false)
            }.onFailure {
                //TODO 예외처리
            }
        }
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
            lottoNumbers.forEach { lottoNumber ->
                postLotterySave(
                    lottoNumber[0].toInt(),
                    lottoNumber[1].toInt(),
                    lottoNumber[2].toInt(),
                    lottoNumber[3].toInt(),
                    lottoNumber[4].toInt(),
                    lottoNumber[5].toInt()
                )
            }
            getLotteryGet()
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
