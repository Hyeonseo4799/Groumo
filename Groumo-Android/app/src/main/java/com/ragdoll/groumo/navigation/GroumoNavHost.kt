package com.ragdoll.groumo.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.ragdoll.group.navigation.groupScreen
import com.ragdoll.group.navigation.navigationToGroup
import com.ragdoll.home.navigation.homeScreen
import com.ragdoll.home.navigation.navigateToHome
import com.ragdoll.mypage.navigation.mypageScreen
import com.ragdoll.navigation.loginRoute
import com.ragdoll.navigation.loginScreen
import com.ragdoll.search.navigation.navigateToSearch
import com.ragdoll.search.navigation.searchScreen
import com.ragdoll.trading.navigation.tradingScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GroumoNavHost(
    navController: NavHostController,
    startDefinition: String = loginRoute,
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
            },
            navigateToHome = {
                navController.navigateToHome()
            }
        )
        searchScreen()
        tradingScreen()
        homeScreen()
        mypageScreen()
    }
}