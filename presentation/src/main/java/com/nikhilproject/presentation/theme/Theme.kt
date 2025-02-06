package com.nikhilproject.presentation.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = primary,
    secondary = colorPrimaryDark,
)

private val LightColorScheme = lightColorScheme(
    primary = primary,
    secondary = colorPrimaryDark,
)

@Composable
fun FootballClubDetailTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }


    val customColorsPalette = if (darkTheme) {
        DarkCustomColorsPalette
    } else {
        LightCustomColorsPalette
    }

    val view = LocalView.current
    val statusBarColor = windowBackground.toArgb()
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            val insetsController = WindowCompat.getInsetsController(window, view)
            window.statusBarColor = statusBarColor
            window.navigationBarColor = Color.Black.toArgb()
            insetsController.isAppearanceLightStatusBars = !darkTheme
        }
    }

    CompositionLocalProvider(
        LocalCustomColorPalette provides customColorsPalette
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content
        )
    }
}