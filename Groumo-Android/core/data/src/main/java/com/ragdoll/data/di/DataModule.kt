package com.ragdoll.data.di

import com.ragdoll.data.repository.GroumoRepository
import com.ragdoll.data.repository.GroumoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsGroumoRepository(
        groumoRepositoryImpl: GroumoRepositoryImpl
    ): GroumoRepository
}