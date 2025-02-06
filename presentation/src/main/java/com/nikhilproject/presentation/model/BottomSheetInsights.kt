package com.nikhilproject.presentation.model


data class BottomSheetInsights(
    val itemCount: Int,
    val characterOccurrences: Map<Char, Int>
)
