package com.ragdoll.designsystem.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.*

private val DarkColorScheme = darkColorScheme(
    primary = DarkRed,
    primaryContainer = DarkGray,
    secondary = DarkRed
)

private val LightColorScheme = lightColorScheme(
    primary = DarkRed,
    primaryContainer = Color.White,
    secondary = LightRed
)

@Composable
fun GroumoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb()
            WindowCompat.setDecorFitsSystemWindows(window, false)
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }

        MaterialTheme(
            colorScheme = colorScheme,
            typography = GroumoTypography,
            content = content
        )
    }
}