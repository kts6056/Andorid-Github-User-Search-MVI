package com.kts6056.data.di

import android.content.Context
import com.kts6056.data.local.UserRoomDataBase
import com.kts6056.data.local.dao.RemoteKeyDao
import com.kts6056.data.local.dao.BookmarkDao
import com.kts6056.data.local.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object PersistentModule {
    @Provides
    @Singleton
    fun provideUserRoomDataBase(
        @ApplicationContext context: Context
    ): UserRoomDataBase {
        return UserRoomDataBase.createUserRoomDataBase(context)
    }

    @Provides
    @Singleton
    fun provideUserDao(
        userRoomDataBase: UserRoomDataBase
    ): UserDao {
        return userRoomDataBase.userDao()
    }

    @Provides
    @Singleton
    fun provideUserBookmarkDao(
        userRoomDataBase: UserRoomDataBase
    ): BookmarkDao {
        return userRoomDataBase.userBookmarkDao()
    }

    @Provides
    @Singleton
    fun provideRemoteKeyDao(
        userRoomDataBase: UserRoomDataBase
    ): RemoteKeyDao {
        return userRoomDataBase.remoteKeyDao()
    }
}
