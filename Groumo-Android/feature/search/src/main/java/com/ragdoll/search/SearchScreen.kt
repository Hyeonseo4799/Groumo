package com.ragdoll.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.ragdoll.model.Group

@Composable
fun SearchRoute(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel(),
) {
    val groups = viewModel.getAllGroups().collectAsLazyPagingItems()
    SearchScreen(
        modifier = modifier,
        groups = groups,
        attendGroup = viewModel::attendGroup
    )
}

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    groups: LazyPagingItems<Group>,
    attendGroup: (Int) -> Unit
) {
    Column(modifier = modifier.systemBarsPadding()) {
        GroupList(groups, attendGroup)
    }
}