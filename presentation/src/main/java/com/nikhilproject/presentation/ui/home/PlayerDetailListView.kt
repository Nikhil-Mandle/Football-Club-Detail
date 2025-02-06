package com.nikhilproject.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.nikhilproject.domain.model.PlayerDetail
import com.nikhilproject.presentation.ui.components.FootballClubCarousel
import com.nikhilproject.presentation.ui.components.PlayerDetailCardItemView
import com.nikhilproject.presentation.ui.components.SearchInputView
import com.nikhilproject.presentation.R


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PlayerDetailListView(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    carouselImage: List<Int>,
    playerDetailList: List<PlayerDetail>,
    userQuery: String,
    onSearchChange: (String) -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    LazyColumn(
        modifier = modifier
            .wrapContentHeight()
    ) {
        item {
            FootballClubCarousel(
                carouselItems = carouselImage,
                pagerState = pagerState
            )
        }

        stickyHeader {
            Surface(modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.margin_small))) {
                SearchInputView(userQuery) { value ->
                    onSearchChange(value)
                }
            }
        }


        itemsIndexed(playerDetailList) { _, cardItem ->
            Column(Modifier.padding(vertical = dimensionResource(id = R.dimen.dp_3))) {
                PlayerDetailCardItemView(cardItem)
            }
        }

        item {
            Box(
                modifier = Modifier
                    .padding(bottom = screenHeight * 3 / 4)
            )
        }
    }
}