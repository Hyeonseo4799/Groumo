package com.ragdoll.mypage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.CandlestickChart
import androidx.compose.material.icons.outlined.Home
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
fun MypageRoute(
    navigateToHome: (Int, Int) -> Unit,
    navigateToTrading: (Int, Int) -> Unit,
    viewModel: MypageViewModel = hiltViewModel()
) {
    MypageScreen(
        userId = viewModel.userId,
        groupId = viewModel.groupId,
        navigateToHome = navigateToHome,
        navigateToTrading = navigateToTrading
    )
}

@Composable
fun MypageScreen(
    userId: Int,
    groupId: Int,
    navigateToHome: (Int, Int) -> Unit,
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
                            Destination.Mypage -> true
                            else -> false
                        },
                        icon = {
                            val icon = when (destination) {
                                Destination.Trading -> Icons.Outlined.CandlestickChart
                                Destination.Home -> Icons.Outlined.Home
                                Destination.Mypage -> Icons.Filled.Person
                            }
                            Icon(imageVector = icon, contentDescription = null)
                        },
                        onClick = {
                            when (destination) {
                                Destination.Trading -> navigateToTrading(userId, groupId)
                                Destination.Home -> navigateToHome(userId, groupId)
                                Destination.Mypage -> {}
                            }
                        },
                        label = { Text(text = stringResource(destination.route)) }
                    )
                }
            }
        }
    }
}