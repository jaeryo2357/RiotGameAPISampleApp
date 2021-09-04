package com.minuk.lolapp.di

import com.minuk.lolapp.data.RiotRepository
import com.minuk.lolapp.data.RiotRepositoryImpl
import com.minuk.lolapp.network.RiotService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRiotRepository(
        riotService: RiotService
    ): RiotRepository {
        return RiotRepositoryImpl(riotService)
    }
}