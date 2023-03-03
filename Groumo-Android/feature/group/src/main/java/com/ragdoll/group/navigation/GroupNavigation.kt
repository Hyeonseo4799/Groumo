package com.ragdoll.group.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ragdoll.group.GroupRoute

const val groupRoute = "group_route"

fun NavController.navigationToGroup(userId: Int) {
    this.navigate("$groupRoute/$userId")
}

fun NavGraphBuilder.groupScreen(navigateToSearch: (Int) -> Unit) {
    composable(
        route = "$groupRoute/{userId}",
        arguments = listOf(navArgument("userId") { type = NavType.IntType })
    ) {
        GroupRoute(navigateToSearch)
    }
}