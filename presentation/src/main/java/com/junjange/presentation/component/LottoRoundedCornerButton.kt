package com.junjange.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.junjange.presentation.ui.theme.LottoTheme

@Composable
inline fun LottoRoundedCornerButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    backgroundColor: Color,
    isEnabled: Boolean = true,
    crossinline onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .background(backgroundColor)
            .clickable {
                if (isEnabled) {
                    onClick()
                }
            }
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = buttonText,
            style = LottoTheme.typography.body3,
            color = if (isEnabled) LottoTheme.colors.white else LottoTheme.colors.gray200
        )
    }
}