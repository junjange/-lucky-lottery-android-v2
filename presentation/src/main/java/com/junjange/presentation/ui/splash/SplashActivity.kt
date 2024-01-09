package com.junjange.presentation.ui.splash

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.junjange.presentation.base.BaseActivity
import com.junjange.presentation.ui.main.MainActivity
import com.junjange.presentation.ui.theme.LottoTheme

class SplashActivity : BaseActivity() {

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottoTheme {
                SplashScreen(
                    viewModel = viewModel,
                    navigateToMain = ::startMainActivity,
                    navigateToLogin = ::startLoginActivity
                )
            }
        }
    }

    private fun startMainActivity() {
        MainActivity.startActivity(this)
        finish()
    }

    private fun startLoginActivity() {
        MainActivity.startActivity(this)
        finish()
    }
}