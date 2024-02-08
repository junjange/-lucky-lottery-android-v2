package com.junjange.presentation.ui.mynumber

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.junjange.domain.model.PensionLotteryGetContent
import com.junjange.domain.usecase.GetPensionLotteryGetUseCase

fun createPensionLotteryPagingSource(getPensionLotteryGetUseCase: GetPensionLotteryGetUseCase): Pager<Int, PensionLotteryGetContent> =
    Pager(
        config = PagingConfig(
            pageSize = 10,
            initialLoadSize = 30,
            enablePlaceholders = true
        ),
        initialKey = 1,
        pagingSourceFactory = { PensionLotteryPagingSource(getPensionLotteryGetUseCase = getPensionLotteryGetUseCase) }
    )

class PensionLotteryPagingSource(private val getPensionLotteryGetUseCase: GetPensionLotteryGetUseCase) :
    PagingSource<Int, PensionLotteryGetContent>() {
    override fun getRefreshKey(state: PagingState<Int, PensionLotteryGetContent>): Int? =
        state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PensionLotteryGetContent> {
        val pageIndex = params.key ?: 1

        val result = getPensionLotteryGetUseCase(
            page = pageIndex,
            size = params.loadSize
        )

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