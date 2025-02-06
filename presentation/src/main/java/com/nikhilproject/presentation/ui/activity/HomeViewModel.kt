package com.nikhilproject.presentation.ui.activity

import androidx.lifecycle.viewModelScope
import com.nikhilproject.domain.common.Result
import com.nikhilproject.domain.model.PlayerDetail
import com.nikhilproject.domain.usecase.GetFootballClubDetailUseCase
import com.nikhilproject.presentation.base.BaseViewModel
import com.nikhilproject.presentation.mapper.ResultMapper
import com.nikhilproject.presentation.model.BottomSheetInsights
import com.nikhilproject.presentation.state.HomeUiState
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

    val searchQuery = MutableStateFlow("")
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

    val rewardsList: StateFlow<List<PlayerDetail>> = combine(
        homeUiState, currentSelectedItem, searchQuery
    ) { uiState, index, query ->

        val cardRewards = (uiState as? HomeUiState.Success)
            ?.cardList
            ?.getOrNull(index)
            ?.playerDetails
            .orEmpty()

        if (query.isNotEmpty()) {
            val pattern = ".*$query.*"
            val regex = Regex(pattern, RegexOption.IGNORE_CASE)
            cardRewards.filter { rewards ->
                rewards.name.contains(regex)
            }
        } else {
            cardRewards
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList(),
    )


    val bottomSheetInsights: StateFlow<BottomSheetInsights> = rewardsList
        .map { rewardsList ->
            val characterMap = findTopResults(rewardsList)
            BottomSheetInsights(itemCount = rewardsList.size, characterOccurrences = characterMap)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = BottomSheetInsights(itemCount = 0, characterOccurrences = emptyMap()),
        )


    fun updateSearchQuery(searchInput: String) {
        searchQuery.value = searchInput
    }

    fun updateCurrentCarouselItem(selectedItem: Int) {
        currentSelectedItem.value = selectedItem
    }

    private fun findTopResults(
        rewardsList: List<PlayerDetail>,
        numberOfItems: Int = 3,
    ): Map<Char, Int> {
        val characters = hashMapOf<Char, Int>()
        for (item in rewardsList) {
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