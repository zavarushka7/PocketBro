package com.example.pocketbro.domain.repository

interface TimeScreenRepository {
    // мы не должны знать откуда берем данные (правило единственной ответственности)
    fun getTimeScreen() : Double
}