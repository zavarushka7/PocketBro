package com.example.pocketbro.di

import com.example.pocketbro.data.repository.TimeScreenRepositoryImpl
import com.example.pocketbro.domain.repository.TimeScreenRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindTimeScreenRepository(
        impl: TimeScreenRepositoryImpl
    ): TimeScreenRepository
}