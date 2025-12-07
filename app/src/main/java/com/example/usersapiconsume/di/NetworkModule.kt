package com.example.usersapiconsume.di

import com.example.usersapiconsume.data.api.RandomUsersApiDetails
import com.example.usersapiconsume.data.api.RandomUsersApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit() = Retrofit.Builder()
        .baseUrl(RandomUsersApiDetails.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun providesRandomUserApiService(retrofit: Retrofit): RandomUsersApiService{
        return retrofit.create(RandomUsersApiService::class.java)
    }

}