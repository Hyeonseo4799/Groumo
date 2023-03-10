package com.ragdoll.search.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import com.ragdoll.search.SearchRoute

const val searchRoute = "search_route"

fun NavController.navigateToSearch(userId: Int) {
    this.navigate("$searchRoute/$userId")
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.searchScreen() {
    composable(
        route = "$searchRoute/{userId}",
        arguments = listOf(navArgument("userId") { type = NavType.IntType }),
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        SearchRoute()
    }
}