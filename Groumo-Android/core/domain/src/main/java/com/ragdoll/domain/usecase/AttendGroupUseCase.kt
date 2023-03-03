package com.ragdoll.domain.usecase

import com.ragdoll.data.repository.GroumoRepository
import javax.inject.Inject

class AttendGroupUseCase @Inject constructor(
    private val repository: GroumoRepository
) {
    suspend operator fun invoke(userId: Int, groupId: Int) = repository.attendGroup(userId, groupId)
}