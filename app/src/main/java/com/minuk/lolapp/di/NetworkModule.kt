package com.minuk.lolapp.di

import com.minuk.lolapp.network.RiotService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://ddragon.leagueoflegends.com/cdn/11.17.1/data/ko_KR/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    fun provideRiotService(
        retrofit: Retrofit
    ): RiotService {
        return retrofit.create(RiotService::class.java)
    }

    @Provides
    fun provideDispatchers() = Dispatchers.IO
}