package com.junjange.presentation.ui.randomnumber

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.junjange.presentation.base.BaseActivity
import com.junjange.presentation.ui.main.MainActivity
import com.junjange.presentation.ui.theme.LottoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RandomNumberActivity : BaseActivity() {

    private val viewModel: RandomNumberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottoTheme {
                RandomNumberScreen(viewModel = viewModel)
            }
        }
    }

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, RandomNumberActivity::class.java)
            context.startActivity(intent)
        }
    }
}