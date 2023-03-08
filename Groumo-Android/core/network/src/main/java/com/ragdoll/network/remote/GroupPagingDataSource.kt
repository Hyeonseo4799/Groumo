package com.ragdoll.network.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ragdoll.network.model.GroupResponse
import com.ragdoll.network.retrofit.GroumoApi
import java.util.*

private const val PAGE_INDEX = 1

class GroupPagingDataSource(
    private val groumoApi: GroumoApi,
    private val input: String?
) : PagingSource<Int, GroupResponse>() {
    override fun getRefreshKey(state: PagingState<Int, GroupResponse>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GroupResponse> {
        val page = params.key ?: PAGE_INDEX
        val result = groumoApi.getAllGroups().let { groups ->
            input?.let { text ->
                groups.filter { it.groupName.lowercase(Locale.getDefault()).startsWith(text) }
            } ?: groups
        }

        return LoadResult.Page(
            data = result,
            prevKey = if (page == PAGE_INDEX) null else page - 1,
            nextKey = if (result.lastIndex <= params.loadSize) null else page + 1
        )
    }
}