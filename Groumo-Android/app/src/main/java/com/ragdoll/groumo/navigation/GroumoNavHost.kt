package com.ragdoll.groumo.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.ragdoll.group.navigation.groupScreen
import com.ragdoll.group.navigation.navigationToGroup
import com.ragdoll.home.navigation.homeRoute
import com.ragdoll.home.navigation.homeScreen
import com.ragdoll.home.navigation.navigateToHome
import com.ragdoll.mypage.navigation.mypageRoute
import com.ragdoll.mypage.navigation.mypageScreen
import com.ragdoll.mypage.navigation.navigateToMypage
import com.ragdoll.navigation.loginRoute
import com.ragdoll.navigation.loginScreen
import com.ragdoll.search.navigation.navigateToSearch
import com.ragdoll.search.navigation.searchScreen
import com.ragdoll.trading.navigation.navigateToTrading
import com.ragdoll.trading.navigation.tradingRoute
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
            navigateToHome = { userId, groupId ->
                navController.navigateToHome(userId, groupId)
            }
        )
        searchScreen()
        tradingScreen(
            navigateToHome = { userId, groupId ->
                navController.navigateToHome(userId, groupId)
            },
            navigateToMypage = { userId, groupId ->
                navController.navigateToMypage(userId, groupId)
            },

        )
        homeScreen(
            navigateToMypage = { userId, groupId ->
                navController.navigateToMypage(userId, groupId)
            },
            navigateToTrading = { userId, groupId ->
                navController.navigateToTrading(userId, groupId)
            }
        )
        mypageScreen(
            navigateToTrading = { userId, groupId ->
                navController.navigateToTrading(userId, groupId)
            },
            navigateToHome = { userId, groupId ->
                navController.navigateToHome(userId, groupId)
            }
        )
    }
}