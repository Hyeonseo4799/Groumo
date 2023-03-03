package com.ragdoll.search

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.ragdoll.domain.usecase.AttendGroupUseCase
import com.ragdoll.domain.usecase.GetAllGroupsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getAllGroupsUseCase: GetAllGroupsUseCase,
    private val attendGroupUseCase: AttendGroupUseCase,
) : ViewModel() {
    private val userId: Int = checkNotNull(savedStateHandle["userId"])

    fun getAllGroups() = getAllGroupsUseCase().cachedIn(viewModelScope)

    fun attendGroup(groupId: Int) {
        Log.d("tag", "clicked")
        viewModelScope.launch {
            attendGroupUseCase(userId, groupId)
        }
    }
}