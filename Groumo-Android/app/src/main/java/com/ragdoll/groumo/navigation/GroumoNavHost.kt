package com.ragdoll.groumo.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.ragdoll.group.navigation.groupScreen
import com.ragdoll.group.navigation.navigationToGroup
import com.ragdoll.navigation.loginRoute
import com.ragdoll.navigation.loginScreen
import com.ragdoll.search.navigation.navigateToSearch
import com.ragdoll.search.navigation.searchScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GroumoNavHost(
    navController: NavHostController,
    startDefinition: String = loginRoute
) {
    AnimatedNavHost(navController = navController, startDestination = startDefinition) {
        loginScreen(
            navigateToLogin = { userId ->
                navController.navigationToGroup(userId, loginRoute)
            }
        )
        groupScreen(
            navigateToSearch = { userId ->
                navController.navigateToSearch(userId)
            }
        )
        searchScreen()
    }
}