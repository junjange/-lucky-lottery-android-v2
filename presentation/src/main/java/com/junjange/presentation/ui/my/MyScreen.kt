package com.junjange.presentation.ui.my

import androidx.compose.foundation.layout.Column
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.junjange.presentation.R
import com.junjange.presentation.component.LottoButtonBar
import com.junjange.presentation.component.LottoSimpleTopBar
import com.junjange.presentation.component.LottoSwitchBar
import com.junjange.presentation.component.LottoTextBar
import com.junjange.presentation.ui.my.MyEffect.NavigateToEditProfile
import com.junjange.presentation.ui.my.MyEffect.NavigateToUsageTerm
import com.junjange.presentation.ui.theme.LottoTheme
import com.junjange.presentation.ui.theme.White
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MyScreen(
    viewModel: MyViewModel = hiltViewModel(),
    navigateToWithdrawal: () -> Unit,
    navigateToSplash: () -> Unit,
    navigateToEditProfile: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val context = LocalContext.current

    val usageTermUri = "https://fre2-dom.tistory.com/7"
    val intent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse(usageTermUri)
    )

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is NavigateToEditProfile -> navigateToEditProfile()
                is NavigateToUsageTerm -> context.startActivity(intent)
                is MyEffect.NavigateToSplash -> navigateToSplash()
                is MyEffect.NavigateToWithdrawal -> navigateToWithdrawal()
            }
        }
    }

    Scaffold(
        topBar = { LottoSimpleTopBar(titleRes = R.string.my) }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Box {
                Surface(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 24.dp)
                        .fillMaxWidth(),
                    color = LottoTheme.colors.lottoBlack,
                    shape = RoundedCornerShape(32.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(32.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box {
                            // TODO 임시 데이터
                            AsyncImage(
                                model = "https://www.ikbc.co.kr/data/kbc/image/2023/08/13/kbc202308130007.800x.0.jpg",
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(120.dp)
                                    .clip(RoundedCornerShape(32.dp))
                                    .border(
                                        width = 1.dp,
                                        color = White,
                                        shape = RoundedCornerShape(32.dp)
                                    )
                            )
                            Image(
                                painter = painterResource(id = R.drawable.ic_profile_edit),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(32.dp)
                                    .offset(x = 4.dp, y = 4.dp)
                                    .align(Alignment.BottomEnd)
                                    .clickable { viewModel.onClickedEditProfile() }
                            )
                        }
                        Spacer(modifier = Modifier.width(32.dp))
                        Column {
                            // TODO 임시 데이터
                            Text(
                                text = "조준장",
                                style = LottoTheme.typography.headline1
                            )
                            Text(
                                text = stringResource(id = R.string.login_with_kakao),
                                style = LottoTheme.typography.body2
                            )
                        }
                    }
                }
            }
            Divider(thickness = 8.dp, color = LottoTheme.colors.gray200)
            Column(
                modifier = Modifier.padding(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                LottoSwitchBar(
                    textRes = R.string.app_notification,
                    isSwitchedOn = uiState.isNotificationAvailable,
                    onSwitchOn = { viewModel.setNotification(true) },
                    onSwitchOff = { viewModel.setNotification(false) }
                )
                LottoTextBar(
                    textRes = R.string.version_info,
                    subtextRes = R.string.newest_version
                )
                LottoButtonBar(
                    textRes = R.string.usage_term,
                    onClick = { viewModel.onClickedUsageTerm() }
                )
                LottoButtonBar(
                    textRes = R.string.sign_out,
                    onClick = { viewModel.onClickedSignOut() }
                )
                LottoButtonBar(
                    textRes = R.string.withdraw_lotto,
                    onClick = { viewModel.onClickedWithdrawal() }
                )
            }
        }
    }
}
