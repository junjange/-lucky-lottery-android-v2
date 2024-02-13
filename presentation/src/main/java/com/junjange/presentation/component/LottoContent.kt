package com.junjange.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.junjange.domain.model.WinningLotteryNumbers
import com.junjange.domain.model.WinningPensionLotteryBonusNumbers
import com.junjange.presentation.R
import com.junjange.presentation.ui.theme.LottoTheme
import java.text.SimpleDateFormat
import java.util.Locale

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
    LottoContentTitle(
        title = stringResource(R.string.lotto_645_title),
        round = 937,
        winningDate = "2024-02-12"
    )
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
    LottoContentTitle(
        title = stringResource(R.string.lotto_720_title),
        round = 937,
        winningDate = "2024-02-12"
    )
    Lotto720Content()
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun LottoContentTitle(
    title: String,
    round: Int,
    winningDate: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = title,
            style = LottoTheme.typography.headline3,
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "${round}회 당첨결과",
            style = LottoTheme.typography.body1,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "(${winningDate.parseDateToKoreanFormat()} 추첨)",
            style = LottoTheme.typography.body3,
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}

fun String.parseDateToKoreanFormat(): String {
    val inputFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val outputFormatter = SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault())

    val parsedDateTime = inputFormatter.parse(this)
    return parsedDateTime?.let { outputFormatter.format(it) } ?: run { "잘못된 날짜" }

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

@Composable
fun Lotto720Content(
    winningLotteryNumbers: WinningLotteryNumbers,
    winningPensionLotteryBonusNumbers: WinningPensionLotteryBonusNumbers
) {

    val winningLotteryNumbersTitle = listOf(
        winningLotteryNumbers.lotteryGroup,
        winningLotteryNumbers.winningFirstNum,
        winningLotteryNumbers.winningSecondNum,
        winningLotteryNumbers.winningThirdNum,
        winningLotteryNumbers.winningFourthNum,
        winningLotteryNumbers.winningFifthNum,
        winningLotteryNumbers.winningSixthNum
    ).map { it.toString() }

    val winningPensionLotteryBonusNumbersTitle = listOf(
        "각",
        winningPensionLotteryBonusNumbers.bonusFirstNum,
        winningPensionLotteryBonusNumbers.bonusSecondNum,
        winningPensionLotteryBonusNumbers.bonusThirdNum,
        winningPensionLotteryBonusNumbers.bonusFourthNum,
        winningPensionLotteryBonusNumbers.bonusFifthNum,
        winningPensionLotteryBonusNumbers.bonusSixthNum,
    ).map { it.toString() }


    val lotteryColors = listOf(
        LottoTheme.colors.lottoBlack,
        LottoTheme.colors.lottoGreen,
        LottoTheme.colors.lottoError,
        LottoTheme.colors.lottoGreen,
        LottoTheme.colors.lottoOrange,
        LottoTheme.colors.lottoPurple,
        LottoTheme.colors.lottoYellow,
    )

    Row(
        modifier = Modifier.padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        winningLotteryNumbersTitle.forEachIndexed { index, title ->
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
                lottoColor = lotteryColors[index],
                lottoTitle = title
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
        winningPensionLotteryBonusNumbersTitle.forEachIndexed { index, title ->
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
                lottoColor = lotteryColors[index],
                lottoTitle = title
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