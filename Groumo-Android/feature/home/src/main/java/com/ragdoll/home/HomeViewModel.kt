package com.ragdoll.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class HomeViewModel (
    savedStateHandle: SavedStateHandle
): ViewModel() {
    val userId: Int = savedStateHandle["userId"]!!
    val groupId: Int = savedStateHandle["groupId"]!!
}