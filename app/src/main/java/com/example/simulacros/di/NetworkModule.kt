//Dependency Injection
package com.example.simulacros.di

import com.example.simulacros.core.Config
import com.example.simulacros.core.InterceptorCustom
import com.example.simulacros.data.network.FlightApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    var client : OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(interceptor).addInterceptor(InterceptorCustom)
    }.build()

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        val baseUrl = Config.baseUrl
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideFlightApiClient(retrofit: Retrofit):FlightApiClient{
        return retrofit.create(FlightApiClient::class.java)
    }
}