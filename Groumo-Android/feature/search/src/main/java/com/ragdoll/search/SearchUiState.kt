package com.ragdoll.search

import com.ragdoll.model.Group

sealed interface SearchUiState {
    data class Success(val groups: List<Group>): SearchUiState
    data class Error(val message: String): SearchUiState
    object Loading: SearchUiState
}