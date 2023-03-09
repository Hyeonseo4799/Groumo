package com.ragdoll.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.CandlestickChart
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.ragdoll.common.destination.Destination
import com.ragdoll.common.destination.destinations
import com.ragdoll.designsystem.component.GroumoNavBar
import com.ragdoll.designsystem.component.GroumoNavBarItem

@Composable
fun HomeRoute(
    navigateToMypage: (Int, Int) -> Unit,
    navigateToTrading: (Int, Int) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen(
        userId = viewModel.userId,
        groupId = viewModel.groupId,
        navigateToMypage = navigateToMypage,
        navigateToTrading = navigateToTrading,
    )
}

@Composable
fun HomeScreen(
    userId: Int,
    groupId: Int,
    navigateToMypage: (Int, Int) -> Unit,
    navigateToTrading: (Int, Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding(),
        verticalArrangement = Arrangement.Bottom
    ) {
        GroumoNavBar {
            GroumoNavBar(
                modifier = modifier
            ) {
                destinations.forEach { destination ->
                    GroumoNavBarItem(
                        selected = when (destination) {
                            Destination.Home -> true
                            else -> false
                        },
                        icon = {
                            val icon = when (destination) {
                                Destination.Trading -> Icons.Outlined.CandlestickChart
                                Destination.Home -> Icons.Filled.Home
                                Destination.Mypage -> Icons.Outlined.Person
                            }
                            Icon(imageVector = icon, contentDescription = null)
                        },
                        onClick = {
                            when (destination) {
                                Destination.Trading -> navigateToTrading(userId, groupId)
                                Destination.Home -> {}
                                Destination.Mypage -> navigateToMypage(userId, groupId)
                            }
                        },
                        label = { Text(text = stringResource(destination.route)) }
                    )
                }
            }
        }
    }
}