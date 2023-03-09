package com.ragdoll.trading.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.navArgument
import com.ragdoll.trading.TradingRoute

const val tradingRoute = "trading_route"

fun NavController.navigateToTrading(userId: Int, groupId: Int) {
    this.navigate("$tradingRoute/$userId/$groupId")
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.tradingScreen(
    navigateToMypage: (Int, Int) -> Unit,
    navigateToHome: (Int, Int) -> Unit
) {
    composable(
        route = "$tradingRoute/{userId}/{groupId}",
        arguments = listOf(
            navArgument("userId") { type = NavType.IntType },
            navArgument("groupId") { type = NavType.IntType }
        ),
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        TradingRoute(
            navigateToMypage = navigateToMypage,
            navigateToHome = navigateToHome
        )
    }
}