package com.ragdoll.trading

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class TradingViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    val userId: Int = savedStateHandle["userId"]!!
    val groupId: Int = savedStateHandle["groupId"]!!
}