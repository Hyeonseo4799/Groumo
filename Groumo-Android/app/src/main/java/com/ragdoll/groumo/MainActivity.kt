package com.ragdoll.groumo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CandlestickChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.CandlestickChart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.ragdoll.common.destination.Destination
import com.ragdoll.designsystem.component.GroumoNavBar
import com.ragdoll.designsystem.component.GroumoNavBarItem
import com.ragdoll.designsystem.theme.GroumoTheme
import com.ragdoll.designsystem.theme.lineSeed
import com.ragdoll.groumo.navigation.GroumoNavHost
import com.ragdoll.groumo.navigation.destinations
import com.ragdoll.groumo.navigation.navigateToDestination
import com.ragdoll.home.navigation.homeRoute
import com.ragdoll.mypage.navigation.mypageRoute
import com.ragdoll.trading.navigation.tradingRoute
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalAnimationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroumoTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberAnimatedNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.destination
                    val enabledBottomBar = currentRoute?.route.let {
                        val routes = listOf(tradingRoute, homeRoute, mypageRoute)
                        routes.contains(it)
                    }

                    Scaffold(
                        bottomBar = {
                            if (enabledBottomBar) {
                                GroumoBottomBar(
                                    destinations = destinations,
                                    onNavigateToDestination = { navController.navigateToDestination(it) },
                                    currentRoute = currentRoute?.route
                                )
                            }
                        }
                    ) {
                        GroumoNavHost(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
private fun GroumoBottomBar(
    destinations: List<Destination>,
    onNavigateToDestination: (Destination) -> Unit,
    currentRoute: String?,
    modifier: Modifier = Modifier
) {
    GroumoNavBar(modifier = modifier) {
        destinations.forEach { destination ->
            val selected = currentRoute?.let { destination.route == currentRoute } ?: false

            GroumoNavBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    val icon = when (destination) {
                        is Destination.Home -> if (selected) Icons.Filled.Home else Icons.Outlined.Home
                        is Destination.Mypage -> if (selected) Icons.Filled.Person else Icons.Outlined.Person
                        is Destination.Trading -> if (selected) Icons.Filled.CandlestickChart else Icons.Outlined.CandlestickChart
                    }
                    Icon(imageVector = icon, contentDescription = null)
                },
                label = { Text(text = stringResource(destination.label), fontFamily = lineSeed) }
            )
        }
    }
}