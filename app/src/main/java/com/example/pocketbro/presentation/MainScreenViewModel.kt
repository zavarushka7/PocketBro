package com.example.pocketbro.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocketbro.domain.usecase.GetFatigueUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getFatigueUseCase: GetFatigueUseCase  // ← Только один параметр!
) : ViewModel() {
    private val _uiState = MutableStateFlow(PocketBroUiState())
    val uiState: StateFlow<PocketBroUiState> = _uiState.asStateFlow()

    init {
        updatePocketBroState()
    }

    fun updatePocketBroState() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)

            val (fatigue, screenTime) = getFatigueUseCase()

            _uiState.value = PocketBroUiState(
                fatigue = fatigue,
                screenTime = screenTime,
                isLoading = false
            )
        }
    }
}