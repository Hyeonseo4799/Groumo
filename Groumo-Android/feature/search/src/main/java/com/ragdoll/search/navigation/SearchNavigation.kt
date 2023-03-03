package com.ragdoll.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ragdoll.search.SearchRoute

const val searchRoute = "search_route"

fun NavController.navigateToSearch(userId: Int) {
    this.navigate("$searchRoute/$userId")
}

fun NavGraphBuilder.searchScreen() {
    composable(
        route = "$searchRoute/{userId}",
        arguments = listOf(navArgument("userId") { type = NavType.IntType })
    ) {
        SearchRoute()
    }
}