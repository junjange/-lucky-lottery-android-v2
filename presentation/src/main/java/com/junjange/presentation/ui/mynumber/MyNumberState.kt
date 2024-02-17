package com.junjange.presentation.ui.mynumber

import androidx.paging.PagingData
import com.junjange.domain.model.LotteryGetContent
import com.junjange.domain.model.PensionLotteryGetContent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


data class MyNumberState(
    val isLoading: Boolean = false,
    val tempList: List<List<List<String>>> = List(10) { List(7) { (List(6) { it.toString() }) } },
    var pensionLotteryGetContent: Flow<PagingData<PensionLotteryGetContent>> = emptyFlow(),
    var lotteryGetContent: Flow<PagingData<LotteryGetContent>> = emptyFlow(),
)

sealed class MyNumberEffect {
    data object NavigateToGallery : MyNumberEffect()
}