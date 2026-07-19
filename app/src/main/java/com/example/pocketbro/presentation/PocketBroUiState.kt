package com.example.pocketbro.presentation

import com.example.pocketbro.domain.Fatigue

data class PocketBroUiState(
    val fatigue: Fatigue = Fatigue.NONE,
    val screenTime: Double = 0.0,
    val isLoading: Boolean = false
)
