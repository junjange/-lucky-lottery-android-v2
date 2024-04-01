package com.junjange.presentation.ui.withdrawal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.junjange.presentation.base.BaseActivity
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
                    gotoTitle = ::navigateToSplash,
                    onBack = ::finish,
                )
            }
        }
    }

    private fun navigateToSplash() {}

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, WithdrawalActivity::class.java)
            context.startActivity(intent)
        }
    }
}
