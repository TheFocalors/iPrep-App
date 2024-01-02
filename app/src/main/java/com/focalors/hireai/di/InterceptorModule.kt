package com.focalors.hireai.di

import com.focalors.hireai.data.local.UserPreferences
import com.focalors.hireai.data.remote.TokenInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InterceptorModule {

    @Provides
    @Singleton
    fun provideTokenInterceptor(userPreferences: UserPreferences): TokenInterceptor {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.83/v1/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        return TokenInterceptor(userPreferences, retrofit)
    }
}