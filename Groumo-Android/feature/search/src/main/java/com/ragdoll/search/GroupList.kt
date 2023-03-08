package com.ragdoll.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.ragdoll.designsystem.component.CustomDialog
import com.ragdoll.designsystem.theme.lineSeed
import com.ragdoll.model.Group

@Composable
fun GroupList(
    modifier: Modifier = Modifier,
    groups: LazyPagingItems<Group>,
    userGroups: List<Group>,
    attendGroup: (Int) -> Unit,
    checkAttendance: (List<Group>, Group) -> Boolean
) {
    val interactionSource = remember { MutableInteractionSource() }
    var selectGroup by remember { mutableStateOf<Group?>(null) }

    LazyColumn {
        itemsIndexed(groups) { index, group ->
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = modifier
                    .fillMaxWidth()
                    .clickable(
                        onClick = { selectGroup = group },
                        indication = null,
                        interactionSource = interactionSource
                    )

            ) {
                if (index != 0) Spacer(modifier = modifier.height(16.dp))
                Text(
                    text = group!!.groupName,
                    fontFamily = lineSeed,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(modifier.padding(vertical = 12.dp)) {
                        Text(
                            text = group.creator,
                            fontFamily = lineSeed,
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                        Spacer(modifier = modifier.width(10.dp))
                        Text(
                            text = group.endDate,
                            fontFamily = lineSeed,
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                }
                Text(
                    text = group.description,
                    fontFamily = lineSeed,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Spacer(modifier = modifier.height(16.dp))
                if (index < groups.itemCount - 1) Divider(color = Color.LightGray, modifier = modifier.fillMaxWidth())
            }
        }
    }

    selectGroup?.let { group ->
        CustomDialog(onDismissRequest = { selectGroup = null }) {
            GroupDialogContent(
                group = group,
                isAttended = { checkAttendance(userGroups, group) },
                attendGroup = attendGroup,
            ) {
                selectGroup = null
            }
        }
    }
}