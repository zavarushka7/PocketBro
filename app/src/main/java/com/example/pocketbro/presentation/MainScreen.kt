package com.example.pocketbro.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pocketbro.domain.Fatigue


@Composable
fun MainScreen(
    viewModel: MainScreenViewModel,
    modifier: Modifier = Modifier,
    onOpenSettings: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    Column(
        modifier = modifier.fillMaxSize()
    ) {

        if (uiState.fatigue == Fatigue.ERROR){
            Text(text = "Нет доступа к статистике использования")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onOpenSettings) {
                Text("Открыть настройки")
            }
            return@Column
        }

        Text(
                text = "Hello ${uiState.fatigue} ${uiState.screenTime}",
                modifier = modifier
            )


    }

}
