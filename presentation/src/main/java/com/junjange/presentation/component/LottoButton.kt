package com.junjange.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.junjange.presentation.component.LottoButtonDefaults.textStyle
import com.junjange.presentation.ui.theme.LottoTheme

@Composable
fun LottoButton(
    buttonColors: ButtonColors,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(horizontal = 20.dp),
    buttonSize: Int = 45
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(buttonSize.dp),
        enabled = enabled,
        shape = LottoButtonDefaults.ButtonShape,
        colors = buttonColors,
        contentPadding = contentPadding,
    ) {
        Text(
            style = textStyle,
            text = text,
        )
    }
}

object LottoButtonDefaults {
    val ButtonHeight = 56.dp
    val ButtonShape = RoundedCornerShape(16.dp)
    val textStyle
        @Composable
        get() = LottoTheme.typography.body1

    val textGrayButtonColors
        @Composable
        get() = ButtonDefaults.buttonColors(
            containerColor = LottoTheme.colors.lottoGreen,
            contentColor = LottoTheme.colors.gray50,
            disabledContainerColor = LottoTheme.colors.gray200,
            disabledContentColor = LottoTheme.colors.gray900
        )
    val textPurpleButtonColors
        @Composable
        get() = ButtonDefaults.buttonColors(
            containerColor = LottoTheme.colors.gray200,
            contentColor = LottoTheme.colors.lottoGreen,
            disabledContainerColor = LottoTheme.colors.gray200,
            disabledContentColor = LottoTheme.colors.gray900
        )
    val backBlackButtonColors
        @Composable
        get() = ButtonDefaults.buttonColors(
            containerColor = LottoTheme.colors.lottoBlack,
            contentColor = Color.White,
            disabledContainerColor = LottoTheme.colors.gray200,
            disabledContentColor = LottoTheme.colors.gray900
        )
}