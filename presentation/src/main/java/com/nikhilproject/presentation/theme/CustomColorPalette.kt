package com.nikhilproject.presentation.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class CustomColorsPalette(
    val tertiaryColor: Color = Color.Unspecified,
    val transparent: Color = Color.Unspecified,
    val darkGrey: Color = Color.Unspecified,
    val accentColor: Color = Color.Unspecified,
    val screenBackground: Color = Color.Unspecified,
    val searchBackgroundColor: Color = Color.Unspecified,
    val cardSurface: Color = Color.Unspecified,
    val primaryTextColor: Color = Color.Unspecified,
    val secondaryTextColor: Color = Color.Unspecified,
    val cardBorderColor: Color = Color.Unspecified,
    val fabBackgroundColor: Color = Color.Unspecified,
    val activeIndicator: Color = Color.Unspecified,
    val defaultIndicator: Color = Color.Unspecified,
    val colorTertiary: Color = Color.Unspecified,
)

val LocalCustomColorPalette = staticCompositionLocalOf { CustomColorsPalette() }

val LightCustomColorsPalette = CustomColorsPalette(
    tertiaryColor = colorTertiary,
    transparent = transparent,
    darkGrey = darkGrey,
    accentColor = colorAccent,
    screenBackground = windowBackground,
    searchBackgroundColor = searchBackgroundColor,
    cardSurface = cardSurface,
    primaryTextColor = primaryTextColor,
    secondaryTextColor = secondaryTextColor,
    cardBorderColor = cardBorderColor,
    fabBackgroundColor = fabBackgroundColor,
    activeIndicator = activeIndicator,
    defaultIndicator = defaultIndicator
    )
val DarkCustomColorsPalette = CustomColorsPalette(
    tertiaryColor = colorTertiary,
    transparent = transparent,
    darkGrey = darkGrey,
    accentColor = colorAccent,
    screenBackground = windowBackground,
    searchBackgroundColor = searchBackgroundColor,
    cardSurface = cardSurface,
    primaryTextColor = primaryTextColor,
    secondaryTextColor = secondaryTextColor,
    cardBorderColor = cardBorderColor,
    fabBackgroundColor = fabBackgroundColor,
    activeIndicator = activeIndicator,
    defaultIndicator = defaultIndicator
)