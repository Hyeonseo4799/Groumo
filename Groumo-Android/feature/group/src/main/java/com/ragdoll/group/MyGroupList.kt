package com.ragdoll.group

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ragdoll.designsystem.theme.lineSeed
import com.ragdoll.model.Group

@Composable
fun MyGroupList(
    userId: Int,
    groups: List<Group>,
    navigateToHome: (Int, Int) -> Unit,
    leaveGroup: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }

    LazyColumn {
        itemsIndexed(groups) { index, group ->
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = modifier
                    .fillMaxWidth()
                    .clickable { navigateToHome(userId, group.id) }
            ) {
                Spacer(modifier = modifier.height(16.dp))
                Text(
                    text = group.groupName,
                    fontFamily = lineSeed,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
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
                        Text(
                            text = group.description,
                            fontFamily = lineSeed,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                    Image(
                        painter = painterResource(R.drawable.ic_exit),
                        contentDescription = null,
                        modifier = modifier
                            .clickable(
                                onClick = {leaveGroup(group.id)},
                                indication = null,
                                interactionSource = interactionSource
                            )
                            .align(Alignment.Bottom)
                    )
                }
                Spacer(modifier = modifier.height(16.dp))
                if (index < groups.lastIndex) Divider(color = Color.LightGray, modifier = modifier.fillMaxWidth())
            }
        }
    }
}