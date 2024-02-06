package com.junjange.presentation.ui.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.google.zxing.integration.android.IntentIntegrator
import com.junjange.presentation.R
import com.junjange.presentation.base.BaseActivity
import com.junjange.presentation.ui.editprofile.EditProfileActivity
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottoTheme {
                MainScreen(
                    viewModel = viewModel,
                    navigateToQRScanner = ::initiateScan,
                    navigateToRandomNumber = ::startRandomActivity,
                    navigateToEditProfile = ::startEditProfileActivity,
                    navigateToWithdrawal = ::startWithdrawalActivity,
                    navigateToSplash = ::startSplashActivity
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

    private fun onActivityResult(resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(resultCode, data)

        if (result != null) {
            result.contents?.let {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(result.contents))
                startActivity(intent)
            }
        } else {
            super.onActivityResult(resultCode, resultCode, data)
        }
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

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}