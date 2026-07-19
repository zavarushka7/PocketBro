package com.example.pocketbro.domain.usecase

import com.example.pocketbro.domain.Fatigue
import com.example.pocketbro.domain.repository.TimeScreenRepository
import javax.inject.Inject

class GetFatigueUseCase @Inject constructor(
    private val repository: TimeScreenRepository
) {
    operator fun invoke(): Pair<Fatigue, Double> {
        val time = repository.getTimeScreen()

        val fatigue = when {
            time < 0 -> Fatigue.ERROR
            time >= 8.0 -> Fatigue.EXTREME
            time in 5.0..<8.0 -> Fatigue.HARD
            time in 3.0..<5.0 -> Fatigue.MEDIUM
            time in 1.0..<3.0 -> Fatigue.MILD
            time < 1.0 -> Fatigue.NONE
            else -> Fatigue.ERROR
        }
        return Pair(fatigue, time)
    }
}