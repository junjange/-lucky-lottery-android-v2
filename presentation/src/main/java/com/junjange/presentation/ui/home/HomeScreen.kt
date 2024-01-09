package com.junjange.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.junjange.presentation.R
import com.junjange.presentation.component.LottoBall
import com.junjange.presentation.component.LottoHomeTopBar
import com.junjange.presentation.component.LottoType
import com.junjange.presentation.ui.theme.LottoTheme

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LottoHomeTopBar(onActionClick = {})
            LottoContent()
        }

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 15.dp, end = 15.dp),
            containerColor = LottoTheme.colors.lottoGreen,
            onClick = { },
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_qr_code),
                contentDescription = null,
                tint = LottoTheme.colors.white
            )
        }
    }
}

@Composable
fun LottoContent() {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(0.5.dp)
            .padding(
                start = 20.dp,
                end = 20.dp
            )
            .background(color = LottoTheme.colors.gray400)
    )
    LottoContentTitle(title = stringResource(R.string.lotto_645_title))
    Lotto645Content()
    Spacer(modifier = Modifier.height(20.dp))
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(0.5.dp)
            .padding(
                start = 20.dp,
                end = 20.dp
            )
            .background(color = LottoTheme.colors.gray400)
    )
    LottoContentTitle(title = stringResource(R.string.lotto_720_title))
    Lotto720Content()
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun LottoContentTitle(title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = title,
            style = LottoTheme.typography.headline3,
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "937회 당첨결과",
            style = LottoTheme.typography.body1,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "(2024년 1월 3일 추첨)",
            style = LottoTheme.typography.body3,
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun Lotto645Content() {
    // TODO 임시 데이터
    val temp = listOf(
        LottoTheme.colors.lottoBlack to "1",
        LottoTheme.colors.lottoGreen to "2",
        LottoTheme.colors.lottoError to "3",
        LottoTheme.colors.lottoGreen to "4",
        LottoTheme.colors.lottoOrange to "5",
        LottoTheme.colors.lottoPurple to "6",
        LottoTheme.colors.lottoYellow to "7",
    )

    Row(
        modifier = Modifier.padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        temp.forEachIndexed { index, s ->
            if (index == 6) {
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    modifier = Modifier.size(14.dp),
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            LottoBall(
                lottoType = LottoType.LOTTO645,
                lottoColor = s.first,
                lottoTitle = s.second
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(5.dp))
    Text(
        text = stringResource(R.string.winning_numbers_title),
        style = LottoTheme.typography.body3,
    )
}

@Composable
fun Lotto720Content() {
    // TODO 임시 데이터
    val temp = listOf(
        LottoTheme.colors.lottoBlack to "1",
        LottoTheme.colors.lottoGreen to "2",
        LottoTheme.colors.lottoError to "3",
        LottoTheme.colors.lottoGreen to "4",
        LottoTheme.colors.lottoOrange to "5",
        LottoTheme.colors.lottoPurple to "6",
        LottoTheme.colors.lottoYellow to "7",

        )

    val temp2 = listOf(
        LottoTheme.colors.lottoBlack to "각",
        LottoTheme.colors.lottoGreen to "2",
        LottoTheme.colors.lottoError to "3",
        LottoTheme.colors.lottoGreen to "4",
        LottoTheme.colors.lottoOrange to "5",
        LottoTheme.colors.lottoPurple to "6",
        LottoTheme.colors.lottoYellow to "7",
    )

    Row(
        modifier = Modifier.padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        temp.forEachIndexed { index, s ->
            if (index == 1) {
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(id = R.string.group_title),
                    style = LottoTheme.typography.headline3,
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            LottoBall(
                lottoType = LottoType.LOTTO720,
                lottoColor = s.first,
                lottoTitle = s.second
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(5.dp))
    Text(
        text = stringResource(R.string.winning_numbers_title),
        style = LottoTheme.typography.body3,
    )
    Spacer(modifier = Modifier.height(20.dp))
    Row(
        modifier = Modifier.padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        temp2.forEachIndexed { index, s ->
            if (index == 1) {
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(id = R.string.group_title),
                    style = LottoTheme.typography.headline3,
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            LottoBall(
                lottoType = LottoType.LOTTO720,
                lottoColor = s.first,
                lottoTitle = s.second
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
    Spacer(modifier = Modifier.height(5.dp))
    Text(
        text = stringResource(R.string.bonus_numbers_title),
        style = LottoTheme.typography.body3,
    )
}
