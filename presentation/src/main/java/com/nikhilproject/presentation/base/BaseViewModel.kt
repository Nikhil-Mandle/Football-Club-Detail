package com.nikhilproject.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<UiState> : ViewModel() {

    private val initialState by lazy { setInitialState() }

    protected val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<UiState> = _uiState

    abstract fun setInitialState(): UiState

}