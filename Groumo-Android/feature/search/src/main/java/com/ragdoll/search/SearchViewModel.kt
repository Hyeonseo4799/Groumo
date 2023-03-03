package com.ragdoll.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.ragdoll.domain.usecase.GetAllGroupsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getAllGroupsUseCase: GetAllGroupsUseCase
) : ViewModel() {
    fun getAllGroups() = getAllGroupsUseCase().cachedIn(viewModelScope)
}