package com.ragdoll.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.ragdoll.login.LoginRoute

const val loginRoute = "login_route"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.loginScreen(navigateToLogin: (Int) -> Unit) {
    composable(
        route = loginRoute,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        LoginRoute(navigateToLogin)
    }
}