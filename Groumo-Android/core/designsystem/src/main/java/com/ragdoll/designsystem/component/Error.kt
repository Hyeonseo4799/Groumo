package com.ragdoll.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ragdoll.designsystem.R
import com.ragdoll.designsystem.theme.lineSeed

@Composable
fun Error(message: String?) {
    Column {
        Text(
            text = message ?: stringResource(R.string.unknown_error),
            color = Color.Red,
            fontFamily = lineSeed
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(R.string.error),
            fontFamily = lineSeed
        )
    }
}