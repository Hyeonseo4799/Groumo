package com.ragdoll.groumo.navigation

import androidx.navigation.NavController
import androidx.navigation.navOptions
import com.ragdoll.common.destination.Destination
import com.ragdoll.home.navigation.navigateToHome
import com.ragdoll.mypage.navigation.navigateToMypage
import com.ragdoll.trading.navigation.navigateToTrading

fun NavController.navigateToDestination(destination: Destination) {
    val navOptions = navOptions {
        launchSingleTop = true
        popBackStack()
    }
    when (destination) {
        is Destination.Home -> this.navigateToHome(navOptions)
        is Destination.Mypage -> this.navigateToMypage(navOptions)
        is Destination.Trading -> this.navigateToTrading(navOptions)
    }
}