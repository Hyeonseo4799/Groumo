package com.ragdoll.trading.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.*
import com.google.accompanist.navigation.animation.composable
import com.ragdoll.trading.TradingRoute

const val tradingRoute = "trading_route"

fun NavController.navigateToTrading(navOptions: NavOptions? = null) {
    this.navigate(tradingRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.tradingScreen() {
    composable(
        route = tradingRoute,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        TradingRoute()
    }
}