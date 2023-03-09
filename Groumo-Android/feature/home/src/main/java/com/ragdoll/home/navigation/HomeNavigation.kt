package com.ragdoll.home.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.*
import com.google.accompanist.navigation.animation.composable
import com.ragdoll.home.HomeRoute

const val homeRoute = "home_route"

fun NavController.navigateToHome(userId: Int, groupId: Int) {
    this.navigate("$homeRoute/$userId/$groupId")
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeScreen(
    navigateToMypage: (Int, Int) -> Unit,
    navigateToTrading: (Int, Int) -> Unit
) {
    composable(
        route = "$homeRoute/{userId}/{groupId}",
        arguments = listOf(
            navArgument("userId") { type = NavType.IntType },
            navArgument("groupId") { type = NavType.IntType }
        ),
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        HomeRoute(
            navigateToMypage = navigateToMypage,
            navigateToTrading = navigateToTrading
        )
    }
}