package com.ragdoll.domain.usecase

import com.ragdoll.data.repository.GroumoRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val repository: GroumoRepository
) {
      suspend operator fun invoke(platform: String, token: String) {
        repository.signUp(platform, token)
    }
}