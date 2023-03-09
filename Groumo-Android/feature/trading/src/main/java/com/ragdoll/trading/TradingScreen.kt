package com.ragdoll.trading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CandlestickChart
import androidx.compose.material.icons.outlined.Home
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
fun TradingRoute(
    navigateToMypage: (Int, Int) -> Unit,
    navigateToHome: (Int, Int) -> Unit,
    viewModel: TradingViewModel = hiltViewModel()
) {
    TradingScreen(
        userId = viewModel.userId,
        groupId = viewModel.groupId,
        navigateToMypage = navigateToMypage,
        navigateToHome = navigateToHome
    )
}

@Composable
fun TradingScreen(
    userId: Int,
    groupId: Int,
    navigateToMypage: (Int, Int) -> Unit,
    navigateToHome: (Int, Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding(),
        verticalArrangement = Arrangement.Bottom
    ) {
        GroumoNavBar(
            modifier = modifier
        ) {
            destinations.forEach { destination ->
                GroumoNavBarItem(
                    selected = when (destination) {
                        Destination.Trading -> true
                        else -> false
                    },
                    icon = {
                        val icon = when (destination) {
                            Destination.Trading -> Icons.Filled.CandlestickChart
                            Destination.Home -> Icons.Outlined.Home
                            Destination.Mypage -> Icons.Outlined.Person
                        }
                        Icon(imageVector = icon, contentDescription = null)
                    },
                    onClick = {
                        when (destination) {
                            Destination.Trading -> {}
                            Destination.Home -> navigateToHome(userId, groupId)
                            Destination.Mypage -> navigateToMypage(userId, groupId)
                        }
                    },
                    label = { Text(text = stringResource(destination.route)) }
                )
            }
        }
    }
}