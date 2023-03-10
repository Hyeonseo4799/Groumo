package com.ragdoll.mypage.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.*
import com.google.accompanist.navigation.animation.composable
import com.ragdoll.mypage.MypageRoute

const val mypageRoute = "mypage_route"

fun NavController.navigateToMypage(navOptions: NavOptions? = null) {
    this.navigate(mypageRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.mypageScreen() {
    composable(
        route = mypageRoute,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        MypageRoute()
    }
}