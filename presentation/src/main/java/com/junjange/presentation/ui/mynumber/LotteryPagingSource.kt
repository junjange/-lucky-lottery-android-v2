package com.junjange.presentation.ui.mynumber

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.junjange.domain.model.LotteryGetContent
import com.junjange.domain.usecase.GetLotteryGetUseCase

fun createLotteryPagingSource(getLotteryGetUseCase: GetLotteryGetUseCase): Pager<Int, LotteryGetContent> =
    Pager(
        config = PagingConfig(
            pageSize = 10,
            initialLoadSize = 30,
            enablePlaceholders = true
        ),
        initialKey = 0,
        pagingSourceFactory = { LotteryPagingSource(getLotteryGetUseCase = getLotteryGetUseCase) }
    )

class LotteryPagingSource(private val getLotteryGetUseCase: GetLotteryGetUseCase) :
    PagingSource<Int, LotteryGetContent>() {
    override fun getRefreshKey(state: PagingState<Int, LotteryGetContent>): Int? =
        state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LotteryGetContent> {
        val pageIndex = params.key ?: 0

        val result = getLotteryGetUseCase(
            page = pageIndex,
            size = params.loadSize
        ).onSuccess { Log.d("Ttt onSuccess", it.toString()) }
            .onFailure { Log.d("Ttt onFailure", it.toString()) }

        return result.fold(
            onSuccess = {
                LoadResult.Page(
                    data = it.content,
                    prevKey = null,
                    nextKey = if (it.last) null else pageIndex + 1
                )
            },
            onFailure = {
                LoadResult.Error(it)
            }
        )
    }
}