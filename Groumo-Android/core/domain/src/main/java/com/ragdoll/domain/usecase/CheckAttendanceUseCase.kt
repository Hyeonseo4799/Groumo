package com.ragdoll.domain.usecase

import com.ragdoll.data.repository.GroumoRepository
import javax.inject.Inject

class CheckAttendanceUseCase @Inject constructor(
    private val repository: GroumoRepository
) {
    operator fun invoke(userId: Int) = repository.checkAttendance(userId)
}