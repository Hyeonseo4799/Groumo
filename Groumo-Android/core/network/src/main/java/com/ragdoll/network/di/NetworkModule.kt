package com.ragdoll.network.di

import com.ragdoll.network.remote.GroumoDataSource
import com.ragdoll.network.remote.GroumoDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {
    @Binds
    fun bindsGroumoDataSource(
        groumoDataSourceImpl: GroumoDataSourceImpl
    ): GroumoDataSource
}