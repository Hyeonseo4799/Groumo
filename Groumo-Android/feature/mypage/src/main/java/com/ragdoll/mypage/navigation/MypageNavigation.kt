package com.ragdoll.mypage.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.navArgument
import com.ragdoll.mypage.MypageRoute

const val mypageRoute = "mypage_route"

fun NavController.navigateToMypage(userId: Int, groupId: Int) {
    this.navigate("$mypageRoute/$userId/$groupId") {
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.mypageScreen(
    navigateToHome: (Int, Int) -> Unit,
    navigateToTrading: (Int, Int) -> Unit
) {
    composable(
        route = "$mypageRoute/{userId}/{groupId}",
        arguments = listOf(
            navArgument("userId") { type = NavType.IntType },
            navArgument("groupId") { type = NavType.IntType }
        ),
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        MypageRoute(
            navigateToHome = navigateToHome,
            navigateToTrading = navigateToTrading
        )
    }
}