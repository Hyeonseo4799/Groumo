package com.ragdoll.common.destination

import com.ragdoll.common.R

sealed class Destination(val route: String, val label: Int) {
    data class Trading(val current: String) : Destination(current, R.string.trading)
    data class Home(val current: String) : Destination(current, R.string.home)
    data class Mypage(val current: String) : Destination(current, R.string.mypage)
}