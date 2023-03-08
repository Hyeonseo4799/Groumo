package com.ragdoll.search

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.ragdoll.designsystem.component.Error
import com.ragdoll.designsystem.component.Loading
import com.ragdoll.model.Group
import kotlinx.coroutines.flow.Flow

@Composable
fun SearchRoute(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val searchState by viewModel.uiState.collectAsStateWithLifecycle()

    SearchScreen(
        modifier = modifier,
        uiState = searchState,
        getAllGroups = viewModel::getAllGroups,
        attendGroup = viewModel::attendGroup,
        checkAttendance = viewModel::checkAttendance,
    )
}

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    uiState: SearchUiState,
    getAllGroups: (String?) -> Flow<PagingData<Group>>,
    attendGroup: (Int) -> Unit,
    checkAttendance: (List<Group>, Group) -> Boolean
) {
    var input by remember { mutableStateOf<String?>(null) }
    val groups = getAllGroups(input).collectAsLazyPagingItems()

    when (uiState) {
        is SearchUiState.Success -> {
            Column(
                modifier = modifier
                    .systemBarsPadding()
                    .padding(horizontal = 20.dp)
            ) {
                SearchBar { input = it }
                GroupList(
                    groups = groups,
                    userGroups = uiState.groups,
                    attendGroup = attendGroup,
                    checkAttendance = checkAttendance
                )
            }
        }
        is SearchUiState.Error -> Error(message = uiState.message)
        SearchUiState.Loading -> Loading()
    }
}