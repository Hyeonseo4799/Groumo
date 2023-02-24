package com.ragdoll.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ragdoll.login.LoginRoute

const val loginRoute = "login_route"

fun NavGraphBuilder.loginScreen(navigateToLogin: (Int) -> Unit) {
    composable(route = loginRoute) {
        LoginRoute(navigateToLogin)
    }
}