package com.ragdoll.group.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.navArgument
import com.ragdoll.group.GroupRoute

const val groupRoute = "group_route"

fun NavController.navigationToGroup(userId: Int, loginRoute: String) {
    this.navigate("$groupRoute/$userId") {
        popUpTo(route = loginRoute) {
            inclusive = true
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.groupScreen(navigateToSearch: (Int) -> Unit) {
    composable(
        route = "$groupRoute/{userId}",
        arguments = listOf(
            navArgument("userId") { type = NavType.IntType }
        )
    ) {
        GroupRoute(navigateToSearch)
    }
}