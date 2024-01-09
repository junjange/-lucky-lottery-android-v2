package com.junjange.presentation.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.junjange.presentation.base.BaseActivity
import com.junjange.presentation.ui.editprofile.EditProfileActivity
import com.junjange.presentation.ui.qrscanner.QRScannerActivity
import com.junjange.presentation.ui.randomnumber.RandomNumberActivity
import com.junjange.presentation.ui.theme.LottoTheme
import com.junjange.presentation.ui.withdrawal.WithdrawalActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottoTheme {
                MainScreen(
                    viewModel = viewModel,
                    navigateToQRScanner = ::startQRScannerActivity,
                    navigateToRandomNumber = ::startRandomActivity,
                    navigateToEditProfile = ::startEditProfileActivity,
                    navigateToWithdrawal = ::startWithdrawalActivity,
                    navigateToSplash = ::startSplashActivity
                )
            }
        }
    }

    private fun startQRScannerActivity() {
        QRScannerActivity.startActivity(this)
    }

    private fun startRandomActivity() {
        RandomNumberActivity.startActivity(this)
    }

    private fun startEditProfileActivity() {
        EditProfileActivity.startActivity(this)
    }

    private fun startWithdrawalActivity() {
        WithdrawalActivity.startActivity(this)
    }

    private fun startSplashActivity() {}
}