package com.nikhilproject.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikhilproject.domain.model.PlayerDetail
import com.nikhilproject.presentation.R
import com.nikhilproject.presentation.theme.LocalCustomColorPalette

@Composable
fun PlayerDetailCardItemView(playerDetail: PlayerDetail) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius)))
            .background(
                LocalCustomColorPalette.current.cardSurface
            )
            .border(1.dp, LocalCustomColorPalette.current.cardBorderColor)
            .padding(vertical = dimensionResource(id = R.dimen.dp_5))
    ) {
        Row(
            Modifier
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.dp_60))
                    .aspectRatio(1f)
                    .clip(shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius))),
                painter = painterResource(id = playerDetail.image),
                contentDescription = "Player Detail Image",
                contentScale = ContentScale.FillBounds
            )
            Column(
                Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.margin_medium))
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = playerDetail.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
                Text(
                    modifier = Modifier.padding(top = dimensionResource(id = R.dimen.dp_4)),
                    text = playerDetail.description,
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.Black
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewCardItemView() {
    PlayerDetailCardItemView(
        playerDetail = PlayerDetail(
            name = "Player Name",
            description = "Description",
            image = R.drawable.bg_splash_gradient
        )
    )
}
