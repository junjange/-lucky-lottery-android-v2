package com.junjange.presentation.ui.withdrawal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.junjange.presentation.base.BaseActivity
import com.junjange.presentation.ui.my.OauthProvider
import com.junjange.presentation.ui.theme.LottoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WithdrawalActivity : BaseActivity() {
    private val viewModel: WithdrawViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LottoTheme {
                WithdrawalScreen(
                    viewModel = viewModel,
                    navigateToSplash = ::navigateToSplash,
                    onBack = ::finish,
                )
            }
        }
    }

    private fun navigateToSplash() {}

    companion object {
        const val SIGN_IN_REQUEST_CODE = 1
        const val EXTRA_KEY_OAUTH_PROVIDER = "EXTRA_KEY_OAUTH_PROVIDER"

        fun startActivity(
            context: Context,
            oauthProvider: OauthProvider,
        ) {
            val intent =
                Intent(context, WithdrawalActivity::class.java)
                    .putExtra(EXTRA_KEY_OAUTH_PROVIDER, oauthProvider)
            context.startActivity(intent)
        }
    }
}
