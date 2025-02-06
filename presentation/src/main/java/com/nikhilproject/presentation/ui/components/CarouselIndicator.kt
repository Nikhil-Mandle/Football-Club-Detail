package com.nikhilproject.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.nikhilproject.presentation.theme.LocalCustomColorPalette
import com.nikhilproject.presentation.R

@Composable
fun CarouselIndicator(
    isActive: Boolean
) {
    val color = if (isActive) {
        LocalCustomColorPalette.current.activeIndicator
    } else {
        LocalCustomColorPalette.current.defaultIndicator
    }
    Box(
        modifier = Modifier
            .padding(horizontal = dimensionResource(id = R.dimen.dp_4))
            .size(dimensionResource(id = R.dimen.dp_10))
            .background(color = color, shape = CircleShape)
    ) {

    }
}

@Preview
@Composable
fun PreviewBreadCrumb() {
    CarouselIndicator(isActive = true)
}