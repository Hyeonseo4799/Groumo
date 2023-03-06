package com.ragdoll.group

import com.ragdoll.model.Group

sealed interface GroupUiState {
    object Loading : GroupUiState
    data class Error(val message: String?) : GroupUiState
    data class Success(val group: List<Group>) : GroupUiState
}