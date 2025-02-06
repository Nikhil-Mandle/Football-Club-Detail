package com.nikhilproject.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import com.nikhilproject.presentation.theme.LocalCustomColorPalette
import com.nikhilproject.presentation.ui.components.BottomSheetInsightsView
import com.nikhilproject.presentation.ui.components.FloatingActionButton
import com.nikhilproject.presentation.ui.components.NoDataFoundView
import com.nikhilproject.presentation.ui.components.ProgressBar
import com.nikhilproject.presentation.utils.extension.ViewExtension.getModifierWithScaffoldPadding
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = koinViewModel()
) {
    val focusManager = LocalFocusManager.current

    val bottomSheetState = rememberModalBottomSheetState()
    var isBottomSheetVisible by rememberSaveable { mutableStateOf(false) }

    val homeState = homeViewModel.homeUiState.collectAsState()
    val bottomSheetInsights = homeViewModel.bottomSheetInsights.collectAsState()
    val playerDetailList = homeViewModel.playerDetailList.collectAsState()
    val searchQuery = homeViewModel._searchQuery.collectAsState()

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { (homeState.value as? HomeUiState.Success)?.carouselImages?.size ?: 0 }
    )

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            focusManager.clearFocus()
            homeViewModel.updateCurrentCarouselItem(page)
            homeViewModel.updateSearchQuery("")
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize().background(LocalCustomColorPalette.current.screenBackground),
        floatingActionButton = {
            FloatingActionButton { isBottomSheetVisible = true }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { padding ->

        when (homeState.value) {
            is HomeUiState.Loading -> {
                ProgressBar(modifier = Modifier.getModifierWithScaffoldPadding(paddingValues = padding))
            }

            is HomeUiState.Error -> {
                NoDataFoundView(modifier = Modifier.getModifierWithScaffoldPadding(paddingValues = padding))
            }

            is HomeUiState.Success -> {
                PlayerDetailListView(
                    modifier = Modifier.getModifierWithScaffoldPadding(paddingValues = padding),
                    pagerState = pagerState,
                    carouselImage = (homeState.value as HomeUiState.Success).carouselImages
                        ?: emptyList(),
                    playerDetailList = playerDetailList.value,
                    userQuery = searchQuery.value
                ) { searchInput ->
                    homeViewModel.updateSearchQuery(searchInput)
                }
            }

            is HomeUiState.Nothing -> {

            }
        }

        if (isBottomSheetVisible) {
            BottomSheetInsightsView(
                bottomSheetDetails = bottomSheetInsights.value,
                onDismiss = { isBottomSheetVisible = false },
                modalBottomSheetState = bottomSheetState
            )
        }
    }
}