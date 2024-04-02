package com.junjange.presentation.ui.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.zxing.integration.android.IntentIntegrator
import com.junjange.presentation.R
import com.junjange.presentation.base.BaseActivity
import com.junjange.presentation.ui.editprofile.EditProfileActivity
import com.junjange.presentation.ui.login.LoginActivity
import com.junjange.presentation.ui.notification.NotificationActivity
import com.junjange.presentation.ui.randomnumber.RandomNumberActivity
import com.junjange.presentation.ui.theme.LottoTheme
import com.junjange.presentation.ui.withdrawal.WithdrawalActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private val viewModel: MainViewModel by viewModels()
    private val scanLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            onActivityResult(result.resultCode, result.data)
        }

    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupInterstitialAd()

        setContent {
            LottoTheme {
                MainScreen(
                    viewModel = viewModel,
                    navigateToQRScanner = ::initiateScan,
                    navigateToRandomNumber = ::startRandomActivity,
                    navigateToEditProfile = ::startEditProfileActivity,
                    navigateToWithdrawal = ::startWithdrawalActivity,
                    navigateToSplash = ::startSplashActivity,
                    navigateToNotification = ::startNotificationActivity,
                )
            }
        }
    }

    private fun initiateScan() {
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt(getString(R.string.qr_scanner_hint))
        integrator.setCameraId(0)
        integrator.setBeepEnabled(true)
        integrator.setBarcodeImageEnabled(false)
        integrator.setOrientationLocked(false)
        scanLauncher.launch(integrator.createScanIntent())
    }

    private fun onActivityResult(
        resultCode: Int,
        data: Intent?,
    ) {
        val result = IntentIntegrator.parseActivityResult(resultCode, data)

        if (result != null) {
            if (mInterstitialAd != null) {
                mInterstitialAd?.show(this@MainActivity)
                mInterstitialAd?.fullScreenContentCallback =
                    object : FullScreenContentCallback() {
                        override fun onAdDismissedFullScreenContent() {
                            result.contents?.let {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(result.contents))
                                startActivity(intent)
                            }
                            mInterstitialAd = null
                            setupInterstitialAd()
                        }

                        override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                            mInterstitialAd = null
                        }
                    }
            }
        } else {
            super.onActivityResult(resultCode, resultCode, data)
        }
    }

    private fun setupInterstitialAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            "ca-app-pub-3940256099942544/1033173712",
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    mInterstitialAd = interstitialAd
                }
            },
        )
    }

    private fun startRandomActivity() {
        RandomNumberActivity.startActivity(this)
    }

    private fun startEditProfileActivity(
        nickname: String,
        profilePath: String?,
    ) {
        EditProfileActivity.startActivity(this, nickname, profilePath)
    }

    private fun startNotificationActivity(
        lottoNotificationState: Boolean,
        pensionLottoNotificationState: Boolean,
    ) {
        NotificationActivity.startActivity(
            this,
            lottoNotificationState,
            pensionLottoNotificationState,
        )
    }

    private fun startWithdrawalActivity(oauthProvider: String) {
        WithdrawalActivity.startActivity(this, oauthProvider)
    }

    private fun startSplashActivity() {
        LoginActivity.startActivity(this)
    }

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}
