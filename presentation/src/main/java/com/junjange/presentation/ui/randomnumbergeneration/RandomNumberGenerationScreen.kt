package com.junjange.presentation.ui.randomnumbergeneration

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.junjange.presentation.R
import com.junjange.presentation.component.LottoBall
import com.junjange.presentation.component.LottoRoundedCornerButton
import com.junjange.presentation.component.LottoType
import com.junjange.presentation.ui.theme.LottoTheme

@Composable
fun RandomNumberGenerationScreen(viewModel: RandomNumberGenerationViewModel) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RandomNumberGenerationContent(
                uiState = uiState,
                onCreateClicked = {
                    if (uiState.isLotto645) viewModel.generate645RandomNumbers()
                    else viewModel.generate720RandomNumbers()
                },
                onSaveClicked = { viewModel.generate645RandomNumbers() })
        }
    }
}

@Composable
fun RandomNumberGenerationContent(
    uiState: RandomNumberGenerationState,
    onCreateClicked: () -> Unit,
    onSaveClicked: () -> Unit
) {

    // TODO 임시 데이터
    val temp = listOf(
        LottoTheme.colors.lottoBlack to "1",
        LottoTheme.colors.lottoGreen to "2",
        LottoTheme.colors.lottoError to "3",
        LottoTheme.colors.lottoGreen to "4",
        LottoTheme.colors.lottoOrange to "5",
        LottoTheme.colors.lottoPurple to "6",
    )

    val temp2 = listOf(
        LottoTheme.colors.lottoBlack to "1",
        LottoTheme.colors.lottoGreen to "2",
        LottoTheme.colors.lottoError to "3",
        LottoTheme.colors.lottoGreen to "4",
        LottoTheme.colors.lottoOrange to "5",
        LottoTheme.colors.lottoPurple to "6",
        LottoTheme.colors.lottoPurple to "7",
    )

    Image(
        modifier = Modifier.size(140.dp),
        painter = painterResource(id = R.drawable.ic_random_poster),
        contentDescription = null,
    )

    Spacer(modifier = Modifier.height(10.dp))

    Text(
        text = stringResource(id = if (uiState.isLotto645) R.string.lotto_645_title else R.string.lotto_720_title),
        style = LottoTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
    )

    Spacer(modifier = Modifier.height(30.dp))

    Row(
        modifier = Modifier.padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (uiState.isLotto645) {

            uiState.lotto645Number.forEachIndexed { index, s ->
                LottoBall(
                    lottoType = LottoType.LOTTO645,
                    lottoColor = LottoTheme.colors.lottoGreen,
                    lottoTitle = s.toString()
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
        } else {
            uiState.lotto720Number.forEachIndexed { index, s ->
                if (index == 1) {
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = stringResource(R.string.group_title),
                        style = LottoTheme.typography.headline3,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                LottoBall(
                    lottoType = LottoType.LOTTO720,
                    lottoColor = LottoTheme.colors.lottoGreen,
                    lottoTitle = s.toString()
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
        }

    }

    Spacer(modifier = Modifier.height(20.dp))

    Row(
        modifier = Modifier.padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        LottoRoundedCornerButton(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(8.dp))
                .height(40.dp)
                .width(160.dp),
            buttonText = stringResource(R.string.create_title),
            backgroundColor = LottoTheme.colors.lottoGreen,
            isEnabled = true,
            onClick = { onCreateClicked() }
        )
        Spacer(modifier = Modifier.width(20.dp))
        LottoRoundedCornerButton(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(8.dp))
                .height(40.dp)
                .width(160.dp),
            buttonText = stringResource(R.string.save_title),
            backgroundColor = LottoTheme.colors.lottoGreen,
            isEnabled = true,
            onClick = { onSaveClicked() }
        )
    }
}