package com.ragdoll.mypage

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MypageViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    val userId: Int = savedStateHandle["userId"]!!
    val groupId: Int = savedStateHandle["groupId"]!!
}