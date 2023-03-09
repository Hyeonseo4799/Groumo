package com.ragdoll.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ragdoll.designsystem.theme.lineSeed

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    searchGroup: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }

    BasicTextField(
        value = text,
        onValueChange = {
            text = it
            searchGroup(it)
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp)
            .border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.background, RoundedCornerShape(20.dp))
            .padding(horizontal = 10.dp, vertical = 8.dp),
        singleLine = true,
        enabled = true,
        textStyle = TextStyle(
            fontSize = 14.sp,
            fontFamily = lineSeed,
            color = MaterialTheme.colorScheme.onBackground
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = modifier.padding(end = 4.dp)
                )
                innerTextField()
            }
        },
        cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground)
    )
}