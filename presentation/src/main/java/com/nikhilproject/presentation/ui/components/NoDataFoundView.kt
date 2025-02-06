package com.nikhilproject.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.nikhilproject.presentation.R

@Composable
fun NoDataFoundView(
    modifier: Modifier = Modifier,
    message: String = stringResource(id = R.string.no_data_found)
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(text = message)
    }
}

@Preview
@Composable
private fun Preview() {
    NoDataFoundView(message = stringResource(id = R.string.no_data_found))
}