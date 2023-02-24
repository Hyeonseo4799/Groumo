package com.ragdoll.groumo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.ragdoll.group.navigation.groupScreen
import com.ragdoll.group.navigation.navigationToGroup
import com.ragdoll.navigation.loginRoute
import com.ragdoll.navigation.loginScreen

@Composable
fun GroumoNavHost(
    navController: NavHostController,
    startDefinition: String = loginRoute
) {
    NavHost(navController = navController, startDestination = startDefinition) {
        loginScreen(
            navigateToLogin = { userId ->
                navController.navigationToGroup(userId)
            }
        )
        groupScreen()
    }
}