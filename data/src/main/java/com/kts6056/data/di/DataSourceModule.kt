package com.kts6056.data.di

import com.kts6056.data.datasource.SearchDataSourceImpl
import com.kts6056.data.local.UserDataBaseImpl
import com.kts6056.domain.datasource.SearchDataSource
import com.kts6056.domain.datasource.UserDataBase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindUserDataBase(userDataBaseImpl: UserDataBaseImpl): UserDataBase

    @Binds
    @Singleton
    abstract fun bindSearchDataSource(searchDataSourceImpl: SearchDataSourceImpl): SearchDataSource
}
