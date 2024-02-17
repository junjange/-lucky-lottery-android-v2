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
import com.junjange.domain.model.LotteryNumbers
import com.junjange.domain.model.PensionLotteryHome
import com.junjange.domain.model.WinningLotteryNumbers
import com.junjange.domain.model.WinningPensionLotteryBonusNumbers
import com.junjange.presentation.R
import com.junjange.presentation.ui.theme.LottoTheme
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun LottoContent(
    lotteryNumbers: LotteryNumbers?,
    pensionLotteryHome: PensionLotteryHome?
) {
    lotteryNumbers?.let {
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
            round = lotteryNumbers.round,
            winningDate = lotteryNumbers.winningDate
        )
        Lotto645Content(lotteryNumbers = lotteryNumbers)
        Spacer(modifier = Modifier.height(20.dp))
    }

    pensionLotteryHome?.let {
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
            round = pensionLotteryHome.round,
            winningDate = pensionLotteryHome.winningDate
        )
        Lotto720Content(pensionLotteryHome = pensionLotteryHome)
        Spacer(modifier = Modifier.height(20.dp))
    }
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
fun Lotto645Content(lotteryNumbers: LotteryNumbers) {
    val lotteryContent = listOf(
        LottoTheme.colors.lottoBlack to lotteryNumbers.firstNum,
        LottoTheme.colors.lottoGreen to lotteryNumbers.secondNum,
        LottoTheme.colors.lottoError to lotteryNumbers.thirdNum,
        LottoTheme.colors.lottoGreen to lotteryNumbers.fourthNum,
        LottoTheme.colors.lottoOrange to lotteryNumbers.fifthNum,
        LottoTheme.colors.lottoPurple to lotteryNumbers.sixthNum,
        LottoTheme.colors.lottoYellow to lotteryNumbers.bonusNum,
    )

    Row(
        modifier = Modifier.padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        lotteryContent.forEachIndexed { index, s ->
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
                lottoTitle = s.second.toString()
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
fun Lotto720Content(pensionLotteryHome: PensionLotteryHome) {
    val pensionLotteryContent = listOf(
        LottoTheme.colors.lottoBlack to pensionLotteryHome.lotteryGroup,
        LottoTheme.colors.lottoGreen to pensionLotteryHome.winningFirstNum,
        LottoTheme.colors.lottoError to pensionLotteryHome.winningSecondNum,
        LottoTheme.colors.lottoGreen to pensionLotteryHome.winningThirdNum,
        LottoTheme.colors.lottoOrange to pensionLotteryHome.winningFourthNum,
        LottoTheme.colors.lottoPurple to pensionLotteryHome.winningFifthNum,
        LottoTheme.colors.lottoYellow to pensionLotteryHome.winningSixthNum,
        )

    val pensionBonusLotteryContent = listOf(
        LottoTheme.colors.lottoBlack to "각",
        LottoTheme.colors.lottoGreen to pensionLotteryHome.bonusFirstNum,
        LottoTheme.colors.lottoError to pensionLotteryHome.bonusSecondNum,
        LottoTheme.colors.lottoGreen to pensionLotteryHome.bonusThirdNum,
        LottoTheme.colors.lottoOrange to pensionLotteryHome.bonusFourthNum,
        LottoTheme.colors.lottoPurple to pensionLotteryHome.bonusFifthNum,
        LottoTheme.colors.lottoYellow to pensionLotteryHome.bonusSixthNum,
    )

    Row(
        modifier = Modifier.padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        pensionLotteryContent.forEachIndexed { index, s ->
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
                lottoTitle = s.second.toString()
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
        pensionBonusLotteryContent.forEachIndexed { index, s ->
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
                lottoTitle = s.second.toString()
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