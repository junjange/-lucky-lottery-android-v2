package com.junjange.presentation.ui.mynumber


data class MyNumberState(
    val isLoading: Boolean = false,
    val tempList: List<List<List<String>>> = List(10) { List(7) { (List(6) { it.toString() }) } }
)

sealed class MyNumberEffect {
    data object NavigateToGallery : MyNumberEffect()
}