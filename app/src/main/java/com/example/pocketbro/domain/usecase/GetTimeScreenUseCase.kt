package com.example.pocketbro.domain.usecase

import com.example.pocketbro.domain.repository.TimeScreenRepository
import javax.inject.Inject

class GetTimeScreenUseCase @Inject constructor(
    private val repository: TimeScreenRepository
) {
    operator fun invoke(): Double {
        return repository.getTimeScreen()
    }
}