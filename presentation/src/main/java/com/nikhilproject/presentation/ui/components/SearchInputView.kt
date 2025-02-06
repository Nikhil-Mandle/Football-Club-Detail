package com.nikhilproject.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikhilproject.presentation.theme.LocalCustomColorPalette
import com.nikhilproject.presentation.R

@Composable
fun SearchInputView(
    userQuery: String,
    onSearchTextInput: (String) -> Unit
) {
    val keyboardManager = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier
            .padding(vertical = dimensionResource(id = R.dimen.dp_12))
            .background(LocalCustomColorPalette.current.searchBackgroundColor)
            .border(1.dp, LocalCustomColorPalette.current.accentColor)
    ) {
        OutlinedTextField(
            value = userQuery,
            textStyle = MaterialTheme.typography.titleMedium,
            onValueChange = { value ->
                onSearchTextInput(value)
            },
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(dimensionResource(id = R.dimen.dp_4)))
                .height(dimensionResource(id = R.dimen.dp_50)),
            placeholder = {
                Text(
                    text = "Search...",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.Normal,
                        color = LocalCustomColorPalette.current.darkGrey,
                    ),
                    maxLines = 1
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = LocalCustomColorPalette.current.darkGrey
                )
            },
            trailingIcon = {
                if (userQuery.isNotEmpty()) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear Input",
                        modifier = Modifier.clickable {
                            onSearchTextInput("")
                            keyboardManager?.hide()
                        },
                        tint = LocalCustomColorPalette.current.darkGrey
                    )
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    keyboardManager?.hide()
                    onSearchTextInput(userQuery.lowercase().trim())
                }
            ),
            maxLines = 1,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = LocalCustomColorPalette.current.accentColor
            )
        )
    }
}

@Preview
@Composable
fun PreviewSearchBar() {
    SearchInputView(
        userQuery = "Travel",
        onSearchTextInput = {}
    )
}