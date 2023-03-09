package com.ragdoll.group

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ragdoll.designsystem.component.Error
import com.ragdoll.designsystem.component.Loading
import com.ragdoll.designsystem.theme.lineSeed

@Composable
fun GroupRoute(
    navigateToSearch: (Int) -> Unit,
    navigateToHome: (Int, Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: GroupViewModel = hiltViewModel()
) {
    val groupState by viewModel.uiState.collectAsStateWithLifecycle()

    GroupScreen(
        modifier = modifier,
        userId = viewModel.userId,
        uiState = groupState,
        navigateToSearch = navigateToSearch,
        navigateToHome = navigateToHome,
        getGroup = viewModel::getGroup,
        leaveGroup = viewModel::leaveGroup
    )
}

@Composable
fun GroupScreen(
    modifier: Modifier = Modifier,
    userId: Int,
    uiState: GroupUiState,
    navigateToSearch: (Int) -> Unit,
    navigateToHome: (Int, Int) -> Unit,
    getGroup: () -> Unit,
    leaveGroup: (Int) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    LaunchedEffect(Unit) { getGroup() }

    when (uiState) {
        is GroupUiState.Success -> {
            Column(
                modifier = modifier
                    .systemBarsPadding()
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Spacer(modifier = modifier.height(14.dp))
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = modifier
                        .align(Alignment.End)
                        .clickable(
                            onClick = { navigateToSearch(userId) },
                            indication = rememberRipple(bounded = false),
                            interactionSource = interactionSource
                        )
                )
                if (uiState.group.isEmpty()) EmptyState() else MyGroupList(userId, uiState.group, navigateToHome, leaveGroup)
            }
        }
        is GroupUiState.Error -> Error(uiState.message)
        GroupUiState.Loading -> Loading()
    }
}

@Composable
fun EmptyState(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.no_groups_founded), fontFamily = lineSeed
        )
    }
}