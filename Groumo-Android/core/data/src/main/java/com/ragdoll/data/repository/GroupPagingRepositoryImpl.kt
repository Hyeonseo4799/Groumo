package com.ragdoll.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.ragdoll.data.model.asGroup
import com.ragdoll.model.Group
import com.ragdoll.network.remote.GroupPagingDataSource
import com.ragdoll.network.retrofit.GroumoApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GroupPagingRepositoryImpl @Inject constructor(
    private val groumoApi: GroumoApi
) : GroupPagingRepository {
    override fun getAllGroups(input: String?): Flow<PagingData<Group>> {
        return Pager(
            config = PagingConfig(pageSize = 5),
            pagingSourceFactory = { GroupPagingDataSource(groumoApi, input) }
        ).flow.map { pagingData ->
            pagingData.map { it.asGroup() }
        }
    }
}