package com.nikhilproject.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.nikhilproject.presentation.model.BottomSheetInsights
import com.nikhilproject.presentation.theme.LocalCustomColorPalette
import com.nikhilproject.presentation.R
import com.nikhilproject.presentation.utils.extension.BottomSheetFormatter.formatBottomSheetItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetInsightsView(
    bottomSheetDetails: BottomSheetInsights,
    onDismiss: () -> Unit,
    modalBottomSheetState: SheetState,
) {

    val characters by remember {
        mutableStateOf(bottomSheetDetails.characterOccurrences.entries.toList())
    }

    ModalBottomSheet(
        modifier = Modifier.fillMaxSize(),
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        containerColor = LocalCustomColorPalette.current.screenBackground
    ) {
        Column(
            modifier = Modifier.padding(
                top = dimensionResource(id = R.dimen.margin_large),
                start = dimensionResource(id = R.dimen.horizontal_margin_medium)
            )
        ) {
            Row {
                Text(
                    text = stringResource(id = R.string.rewards_count),
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = bottomSheetDetails.itemCount.toString(),
                    style = MaterialTheme.typography.headlineLarge
                )
            }

            Text(
                modifier = Modifier.padding(top = dimensionResource(id = R.dimen.margin_medium)),
                text = stringResource(id = R.string.top_three_characters),
                style = MaterialTheme.typography.headlineLarge
            )

            Column(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.margin_small))) {
                repeat(characters.size) { index ->
                    Row(Modifier.padding(top = dimensionResource(id = R.dimen.margin_small))) {
                        Text(
                            text = characters[index].key.formatBottomSheetItem(),
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = characters[index].value.toString(),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewBottomSheet() {
    BottomSheetInsightsView(
        bottomSheetDetails = BottomSheetInsights(
            2,
            characterOccurrences = mapOf('k' to 10, 'r' to 4)
        ),
        onDismiss = { },
        modalBottomSheetState = rememberModalBottomSheetState()
    )
}