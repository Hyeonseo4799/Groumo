package com.ragdoll.domain.usecase

import com.ragdoll.data.repository.GroumoRepository
import javax.inject.Inject

class GetGroupUseCase @Inject constructor(
    private val repository: GroumoRepository
) {
    suspend operator fun invoke(userId: Int) = repository.getGroup(userId)
}