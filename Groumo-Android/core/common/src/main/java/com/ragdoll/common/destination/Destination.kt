package com.ragdoll.common.destination

import com.ragdoll.common.R

sealed class Destination(val route: Int) {
    object Trading : Destination(R.string.trading)
    object Home : Destination(R.string.home)
    object Mypage : Destination(R.string.mypage)
}

val destinations = listOf(
    Destination.Trading,
    Destination.Home,
    Destination.Mypage
)