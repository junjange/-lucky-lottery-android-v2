package com.junjange.lotto3.ui.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color

val LottoBlack = Color(0xFF1F2128)
val LottoPurple = Color(0xFF6568EB)
val LottoYellow = Color(0xFFFFF06B)
val LottoWhite = Color(0xFFF9F9F9)
val LottoOrange = Color(0xFFE78111)
val LottoError = Color(0xFFFF4747)

val Gray900 = Color(0xFF212121)
val Gray800 = Color(0xFF424242)
val Gray700 = Color(0xFF616161)
val Gray600 = Color(0xFF757575)
val Gray500 = Color(0xFF9E9E9E)
val Gray400 = Color(0xFFBDBDBD)
val Gray300 = Color(0xFFE0E0E0)
val Gray200 = Color(0xFFEEEEEE)
val Gray100 = Color(0xFFF5F5F5)
val Gray50 = Color(0xFF7F7F7F)

val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)

val MaterialColors = lightColorScheme(
    primary = LottoBlack,
    onPrimary = White,
    secondary = LottoPurple,
    onSecondary = Gray900,
    tertiary = LottoYellow,
    onTertiary = Black,
    error = LottoError,
    onError = White,
    background = LottoWhite,
    surface = LottoWhite
)

@Stable
class LottoColors(
    LottoBlack: Color,
    LottoPurple: Color,
    LottoYellow: Color,
    LottoOrange: Color,
    LottoError: Color,
    gray900: Color,
    gray800: Color,
    gray700: Color,
    gray600: Color,
    gray500: Color,
    gray400: Color,
    gray300: Color,
    gray200: Color,
    gray100: Color,
    gray50: Color
) {
    var LottoBlack: Color by mutableStateOf(LottoBlack, structuralEqualityPolicy())
        private set
    var LottoPurple: Color by mutableStateOf(LottoPurple, structuralEqualityPolicy())
        private set
    var LottoYellow: Color by mutableStateOf(LottoYellow, structuralEqualityPolicy())
        private set
    var LottoOrange: Color by mutableStateOf(LottoOrange, structuralEqualityPolicy())
        private set
    var LottoError: Color by mutableStateOf(LottoError, structuralEqualityPolicy())
        private set
    var gray900: Color by mutableStateOf(gray900, structuralEqualityPolicy())
        private set
    var gray800: Color by mutableStateOf(gray800, structuralEqualityPolicy())
        private set
    var gray700: Color by mutableStateOf(gray700, structuralEqualityPolicy())
        private set
    var gray600: Color by mutableStateOf(gray600, structuralEqualityPolicy())
        private set
    var gray500: Color by mutableStateOf(gray500, structuralEqualityPolicy())
        private set
    var gray400: Color by mutableStateOf(gray400, structuralEqualityPolicy())
        private set
    var gray300: Color by mutableStateOf(gray300, structuralEqualityPolicy())
        private set
    var gray200: Color by mutableStateOf(gray200, structuralEqualityPolicy())
        private set
    var gray100: Color by mutableStateOf(gray100, structuralEqualityPolicy())
        private set
    var gray50: Color by mutableStateOf(gray50, structuralEqualityPolicy())
        private set

    fun copy(
        LottoBlack: Color = this.LottoBlack,
        LottoPurple: Color = this.LottoPurple,
        LottoYellow: Color = this.LottoYellow,
        LottoOrange: Color = this.LottoOrange,
        LottoError: Color = this.LottoError,
        gray900: Color = this.gray900,
        gray800: Color = this.gray800,
        gray700: Color = this.gray700,
        gray600: Color = this.gray600,
        gray500: Color = this.gray500,
        gray400: Color = this.gray400,
        gray300: Color = this.gray300,
        gray200: Color = this.gray200,
        gray100: Color = this.gray100,
        gray50: Color = this.gray50
    ) = LottoColors(
        LottoBlack = LottoBlack,
        LottoPurple = LottoPurple,
        LottoYellow = LottoYellow,
        LottoOrange = LottoOrange,
        LottoError = LottoError,
        gray900 = gray900,
        gray800 = gray800,
        gray700 = gray700,
        gray600 = gray600,
        gray500 = gray500,
        gray400 = gray400,
        gray300 = gray300,
        gray200 = gray200,
        gray100 = gray100,
        gray50 = gray50
    )
}

fun lightColors(
    lottoBlack: Color = LottoBlack,
    lottoPurple: Color = LottoPurple,
    lottoYellow: Color = LottoYellow,
    lottoOrange: Color = LottoOrange,
    lottoError: Color = LottoError,
    gray900: Color = Gray900,
    gray800: Color = Gray800,
    gray700: Color = Gray700,
    gray600: Color = Gray600,
    gray500: Color = Gray500,
    gray400: Color = Gray400,
    gray300: Color = Gray300,
    gray200: Color = Gray200,
    gray100: Color = Gray100,
    gray50: Color = Gray50
) = LottoColors(
    LottoBlack = LottoBlack,
    LottoPurple = LottoPurple,
    LottoYellow = LottoYellow,
    LottoOrange = LottoOrange,
    LottoError = LottoError,
    gray900 = gray900,
    gray800 = gray800,
    gray700 = gray700,
    gray600 = gray600,
    gray500 = gray500,
    gray400 = gray400,
    gray300 = gray300,
    gray200 = gray200,
    gray100 = gray100,
    gray50 = gray50
)

internal val LocalColors = staticCompositionLocalOf { lightColors() }