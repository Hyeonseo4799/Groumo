package com.ragdoll.data.repository

import androidx.paging.PagingData
import com.ragdoll.model.Group
import kotlinx.coroutines.flow.Flow

interface GroupPagingRepository {
    fun getAllGroups(): Flow<PagingData<Group>>
}