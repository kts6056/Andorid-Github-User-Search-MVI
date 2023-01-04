package com.kts6056.data.di

import com.kts6056.data.remote.SearchAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {
    @Provides
    @Singleton
    fun provideSearchService(
        retrofit: Retrofit
    ): SearchAPI = retrofit.create(SearchAPI::class.java)
}
