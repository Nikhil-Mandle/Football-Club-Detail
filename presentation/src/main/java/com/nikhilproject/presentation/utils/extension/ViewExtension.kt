package com.nikhilproject.presentation.utils.extension

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.nikhilproject.presentation.R

object ViewExtension {
    fun View.visibilityToggle(isVisible: Boolean) {
        visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    fun Activity.showToast(message: String) {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

    @Composable
    fun Modifier.getModifierWithScaffoldPadding(
        paddingValues: PaddingValues
    ) = this.padding(
        start = dimensionResource(R.dimen.margin_large),
        end = dimensionResource(R.dimen.margin_large),
        top = paddingValues
            .calculateTopPadding()
            .plus(dimensionResource(id = R.dimen.dp_20)),
        bottom = paddingValues.calculateBottomPadding()
    )
}