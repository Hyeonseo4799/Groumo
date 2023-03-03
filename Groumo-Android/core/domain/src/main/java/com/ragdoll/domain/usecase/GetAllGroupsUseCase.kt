package com.ragdoll.domain.usecase

import com.ragdoll.data.repository.GroupPagingRepository
import javax.inject.Inject

class GetAllGroupsUseCase @Inject constructor(
    private val groupPagingRepository: GroupPagingRepository
) {
    operator fun invoke() = groupPagingRepository.getAllGroups()
}