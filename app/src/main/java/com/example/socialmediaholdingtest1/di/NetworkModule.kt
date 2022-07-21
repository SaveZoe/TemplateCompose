package com.example.socialmediaholdingtest1.di

import com.example.socialmediaholdingtest1.data.network.NetworkRequest
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun createRetrofit(): NetworkRequest {
        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/stellardiver/ebookdata/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(NetworkRequest::class.java)
    }
}