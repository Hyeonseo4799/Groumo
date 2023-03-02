package com.ragdoll.login

import com.ragdoll.model.User

sealed interface UserUiState {
    object Loading : UserUiState
    data class Error(val message: String?) : UserUiState
    data class Success(val user: User?): UserUiState
}