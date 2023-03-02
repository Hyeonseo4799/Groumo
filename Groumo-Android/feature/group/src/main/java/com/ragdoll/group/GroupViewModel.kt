package com.ragdoll.group

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ragdoll.common.result.Result
import com.ragdoll.common.result.asResult
import com.ragdoll.domain.usecase.GetGroupUseCase
import com.ragdoll.domain.usecase.LeaveGroupUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroupViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getGroupUseCase: GetGroupUseCase,
    private val leaveGroupUseCase: LeaveGroupUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<GroupUiState>(GroupUiState.Success(emptyList()))
    val uiState: StateFlow<GroupUiState> = _uiState.asStateFlow()

    private val userId: Int = checkNotNull(savedStateHandle["userId"])

    init {
        getGroup()
    }

    private fun getGroup() {
        viewModelScope.launch {
            getGroupUseCase(userId).asResult().collect { result ->
                when (result) {
                    is Result.Success -> _uiState.value = GroupUiState.Success(result.data)
                    is Result.Error -> _uiState.value = GroupUiState.Error(result.message)
                    Result.Loading -> _uiState.value = GroupUiState.Loading
                }
            }
        }
    }

    fun leaveGroup(groupId: Int) {
        viewModelScope.launch {
            leaveGroupUseCase(userId, groupId).asResult().collect { result ->
                when (result) {
                    is Result.Success -> _uiState.value = GroupUiState.Success(result.data)
                    is Result.Error -> _uiState.value = GroupUiState.Error(result.message)
                    Result.Loading -> _uiState.value = GroupUiState.Loading
                }
            }
        }
    }
}