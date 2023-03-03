package com.ragdoll.network.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ragdoll.network.model.GroupResponse
import com.ragdoll.network.retrofit.GroumoApi

private const val PAGE_INDEX = 1

class GroupPagingDataSource(
    private val groumoApi: GroumoApi
) : PagingSource<Int, GroupResponse>() {
    override fun getRefreshKey(state: PagingState<Int, GroupResponse>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GroupResponse> {
        val page = params.key ?: PAGE_INDEX
        val result = groumoApi.getAllGroups()

        return LoadResult.Page(
            data = result,
            prevKey = if (page == PAGE_INDEX) null else page - 1,
            nextKey = if(result.lastIndex <= params.loadSize) null else page + 1
        )
    }
}