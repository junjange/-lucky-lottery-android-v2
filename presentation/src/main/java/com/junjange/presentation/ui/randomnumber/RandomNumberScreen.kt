package com.junjange.presentation.ui.randomnumber

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.junjange.presentation.R
import com.junjange.presentation.component.LottoType
import com.junjange.presentation.ui.theme.LottoTheme

@Composable
fun RandomNumberScreen(
    viewModel: RandomNumberViewModel,
    navigateRandomNumberGeneration: (lottoType : LottoType) -> Unit
) {

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            RandomNumberCard(
                modifier = Modifier
                    .weight(0.5f)
                    .clickable { navigateRandomNumberGeneration(LottoType.LOTTO645) },
                iconRes = R.drawable.ic_lotto645_random,
                title = R.string.lotto_645_random_title,
                description = R.string.lotto_645_random_description
            )
            RandomNumberCard(
                modifier = Modifier
                    .weight(0.5f)
                    .clickable { navigateRandomNumberGeneration(LottoType.LOTTO720) } ,
                iconRes = R.drawable.ic_lotto720_random,
                title = R.string.lotto_720_title,
                description = R.string.lotto_720_random_description
            )
        }
    }
}

@Composable
fun RandomNumberCard(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int,
    title: Int,
    description: Int
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(containerColor = LottoTheme.colors.white),
        shape = RoundedCornerShape(size = 8.dp),
        border = BorderStroke(width = 1.dp, color = LottoTheme.colors.gray200),
    ) {
        Row(
            modifier = modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = title),
                    style = LottoTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = stringResource(id = description),
                    style = LottoTheme.typography.body4
                )
            }
            Image(
                modifier = Modifier.size(140.dp),
                painter = painterResource(id = iconRes),
                contentDescription = null,
            )
        }
    }
}
