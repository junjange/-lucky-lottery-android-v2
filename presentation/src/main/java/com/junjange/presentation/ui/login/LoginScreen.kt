package com.junjange.presentation.ui.login


import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.junjange.presentation.R
import kotlinx.coroutines.flow.collectLatest


@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    navigateToMain: () -> Unit,
    navigateToRegister: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val SIGN_IN_REQUEST_CODE = 1

    val authResultLauncher = rememberLauncherForActivityResult(
        contract = GoogleSignInContract(),
        onResult = { viewModel.googleLogin(it) }
    )

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collectLatest { effect ->
            when (effect) {
                is LoginEffect.NavigateToMain -> navigateToMain()
                is LoginEffect.NavigateToRegister -> navigateToRegister()
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .align(Alignment.Center),
            painter = painterResource(id = R.drawable.ic_clover),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            LoginButton(iconRes = R.drawable.ic_kakao_login, onClick = { viewModel.kakaoLogin() })
            Spacer(modifier = Modifier.height(8.dp))
            LoginButton(
                iconRes = R.drawable.ic_google_login,
                onClick = { authResultLauncher.launch(SIGN_IN_REQUEST_CODE) })
        }
    }
}

@Composable
fun LoginButton(
    @DrawableRes iconRes: Int,
    onClick: () -> Unit
) {
    Image(
        painter = painterResource(id = iconRes),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(328 / 52f)
            .padding(horizontal = 16.dp)
            .clickable { onClick() }
    )
}