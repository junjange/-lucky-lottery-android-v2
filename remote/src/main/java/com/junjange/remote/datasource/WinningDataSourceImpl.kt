package com.junjange.remote.datasource

import com.junjange.data.datasource.WinningDataSource
import com.junjange.data.model.remote.LotteryNumbersEntity
import com.junjange.data.model.remote.PensionLotteryHomeEntity
import com.junjange.remote.api.ApiService
import com.junjange.remote.model.response.toData
import javax.inject.Inject

internal class WinningDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
) : WinningDataSource {
    override suspend fun getWinningLotteryHome(): Result<LotteryNumbersEntity> = runCatching {
        apiService.getLotteryHome().data.toData()
    }

    override suspend fun getWinningPensionLotteryHome(): Result<PensionLotteryHomeEntity> =
        runCatching {
            apiService.getPensionLotteryHome().data.toData()
        }
}