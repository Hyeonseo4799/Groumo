package com.ragdoll.groumo.navigation

import com.ragdoll.common.destination.Destination
import com.ragdoll.home.navigation.homeRoute
import com.ragdoll.mypage.navigation.mypageRoute
import com.ragdoll.trading.navigation.tradingRoute

val destinations = listOf(
    Destination.Trading(tradingRoute),
    Destination.Home(homeRoute),
    Destination.Mypage(mypageRoute)
)