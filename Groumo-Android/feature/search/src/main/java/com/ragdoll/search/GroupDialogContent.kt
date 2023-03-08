package com.ragdoll.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ragdoll.designsystem.theme.lineSeed
import com.ragdoll.model.Group

@Composable
fun GroupDialogContent(
    modifier: Modifier = Modifier,
    isAttended: () -> Boolean,
    group: Group,
    attendGroup: (Int) -> Unit,
    disableDialog: () -> Unit
) {
    val tags = listOf(group.creator, group.endDate, "${group.initialFunds}원")

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background, RoundedCornerShape(8.dp))
            .padding(20.dp)
    ) {
        Text(
            text = group.groupName,
            fontFamily = lineSeed,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        )
        Spacer(modifier = modifier.height(12.dp))

        GroupTagList(tags = tags)

        Text(
            text = group.description,
            fontFamily = lineSeed,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = modifier.padding(vertical = 12.dp)
        )

        if (!isAttended()) {
            Button(
                onClick = {
                    attendGroup(group.id)
                    disableDialog()
                },
                modifier = modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = stringResource(R.string.attend_group))
            }
        }
    }
}

@Composable
fun GroupTagList(tags: List<String>, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Row(modifier = modifier.horizontalScroll(scrollState)) {
        tags.forEachIndexed { index, tag ->
            Text(
                text = tag,
                modifier = modifier
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(14.dp)
                    )
                    .padding(6.dp),
                fontFamily = lineSeed,
                fontSize = 14.sp
            )
            if (index < tags.size - 1) Spacer(modifier = modifier.width(6.dp))
        }
    }
}