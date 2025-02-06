package com.nikhilproject.presentation.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.nikhilproject.presentation.theme.LocalCustomColorPalette

@Composable
fun FloatingActionButton(
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = {
            onClick()
        },
        containerColor = LocalCustomColorPalette.current.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Info,
            contentDescription = "Floating action button.",
            tint = Color.White,
        )
    }
}

@Preview
@Composable
fun PreviewFloatingButton() {
    FloatingActionButton(
        onClick = { }
    )
}

