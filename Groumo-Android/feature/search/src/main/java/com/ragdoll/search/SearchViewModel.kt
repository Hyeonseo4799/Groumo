package com.ragdoll.search

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.ragdoll.common.result.Result
import com.ragdoll.common.result.asResult
import com.ragdoll.domain.usecase.AttendGroupUseCase
import com.ragdoll.domain.usecase.GetAllGroupsUseCase
import com.ragdoll.domain.usecase.GetGroupUseCase
import com.ragdoll.model.Group
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getAllGroupsUseCase: GetAllGroupsUseCase,
    private val attendGroupUseCase: AttendGroupUseCase,
    private val getGroupUseCase: GetGroupUseCase
) : ViewModel() {
    private val userId: Int = checkNotNull(savedStateHandle["userId"])

    private val _uiState = MutableStateFlow<SearchUiState>(SearchUiState.Loading)
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch { getUserGroup() }
    }

    fun getAllGroups(input: String? = null) = getAllGroupsUseCase(input).cachedIn(viewModelScope)

    fun attendGroup(groupId: Int) {
        viewModelScope.launch {
            attendGroupUseCase(userId, groupId)
            getUserGroup()
        }
    }

    private suspend fun getUserGroup() {
        getGroupUseCase(userId).asResult().collect { result ->
            when (result) {
                is Result.Success -> _uiState.value = SearchUiState.Success(result.data)
                is Result.Error -> _uiState.value = SearchUiState.Error(message = result.message)
                Result.Loading -> _uiState.value = SearchUiState.Loading
            }
        }
    }

    fun checkAttendance(userGroups: List<Group>, group: Group): Boolean = userGroups.any { it.id == group.id }
}