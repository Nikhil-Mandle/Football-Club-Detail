package com.nikhilproject.presentation.ui.home

import androidx.lifecycle.viewModelScope
import com.nikhilproject.domain.common.Result
import com.nikhilproject.domain.model.PlayerDetail
import com.nikhilproject.domain.usecase.GetFootballClubDetailUseCase
import com.nikhilproject.presentation.base.BaseViewModel
import com.nikhilproject.presentation.mapper.ResultMapper
import com.nikhilproject.presentation.model.BottomSheetInsights
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    getFootballClubDetailUseCase: GetFootballClubDetailUseCase
) : BaseViewModel<HomeUiState>() {

    private val searchQuery = MutableStateFlow("")
    val _searchQuery = searchQuery.asStateFlow()

    val currentSelectedItem = MutableStateFlow(-1)
    val _currentSelectedItem = currentSelectedItem.asStateFlow()

    override fun setInitialState(): HomeUiState = HomeUiState.Nothing

    val homeUiState: StateFlow<HomeUiState> = getFootballClubDetailUseCase.invoke()
        .map { resultState ->
            when (resultState) {
                is Result.SuccessState -> ResultMapper.homeStateSuccessMapper(resultState = resultState)
                is Result.ErrorState -> ResultMapper.homeStateErrorMapper(resultState = resultState)
            }
        }.onStart { emit(HomeUiState.Loading) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = HomeUiState.Loading,
        )

    val playerDetailList: StateFlow<List<PlayerDetail>> = combine(
        homeUiState, currentSelectedItem, searchQuery
    ) { uiState, index, query ->

        val playerDetails = (uiState as? HomeUiState.Success)
            ?.footballClubList
            ?.getOrNull(index)
            ?.playerDetails
            .orEmpty()

        if (query.isNotEmpty()) {
            val pattern = ".*$query.*"
            val regex = Regex(pattern, RegexOption.IGNORE_CASE)
            playerDetails.filter { playerDetail ->
                playerDetail.name.contains(regex)
            }
        } else {
            playerDetails
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList(),
    )


    val bottomSheetInsights: StateFlow<BottomSheetInsights> = playerDetailList
        .map { playerDetailList ->
            val characterMap = findTopResults(playerDetailList)
            BottomSheetInsights(itemCount = playerDetailList.size, characterOccurrences = characterMap)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = BottomSheetInsights(itemCount = 0, characterOccurrences = emptyMap()),
        )


    fun updateSearchQuery(searchInput:String){
        searchQuery.value = searchInput
    }

    fun updateCurrentCarouselItem(selectedItem:Int){
        currentSelectedItem.value = selectedItem
    }

    private fun findTopResults(
        playerDetailList: List<PlayerDetail>,
        numberOfItems: Int = 3,
    ): Map<Char, Int> {
        val characters = hashMapOf<Char, Int>()
        for (item in playerDetailList) {
            for (data in item.name) {
                if (!data.isWhitespace()) {
                    characters[data] = (characters[data] ?: 0) + 1
                }
            }
        }
        val sortedMap = characters.entries.sortedByDescending { it.value }
            .take(numberOfItems)
            .associate { it.key to it.value }

        return sortedMap
    }
}