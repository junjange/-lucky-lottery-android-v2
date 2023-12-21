package com.junjange.lotto3.ui.theme

import android.app.Activity
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.junjange.lotto3.ui.theme.LottoTheme.typography

@Composable
fun LottoTheme(
    colors: LottoColors = LottoTheme.colors,
    content: @Composable () -> Unit
) {
    val rememberedColors = remember { colors.copy() }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = MaterialColors.background.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = true
        }
    }

    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalTypography provides typography,
        LocalContentColor provides White
    ) {
        MaterialTheme(
            colorScheme = MaterialColors,
            content = content
        )
    }
}

object LottoTheme {

    val colors: LottoColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: LottoTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}