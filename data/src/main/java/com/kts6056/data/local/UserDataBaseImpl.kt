package com.kts6056.data.local

import com.kts6056.data.local.dao.BookmarkDao
import com.kts6056.data.local.dao.RemoteKeyDao
import com.kts6056.data.local.dao.UserDao
import com.kts6056.data.mapper.BookmarkUserEntityListMapper
import com.kts6056.data.mapper.BookmarkUserEntityMapper
import com.kts6056.data.mapper.RemoteKeyEntityMapper
import com.kts6056.data.model.entity.BookmarkEntity
import com.kts6056.data.model.entity.toEntity
import com.kts6056.domain.DomainListModel
import com.kts6056.domain.None
import com.kts6056.domain.datasource.UserDataBase
import com.kts6056.domain.model.BookmarkUser
import com.kts6056.domain.model.RemoteKey
import com.kts6056.domain.model.User
import javax.inject.Inject

internal class UserDataBaseImpl @Inject constructor(
    private val userDao: UserDao,
    private val bookmarkDao: BookmarkDao,
    private val remoteKeyDao: RemoteKeyDao
) : UserDataBase {
    override suspend fun addUserList(
        query: String,
        page: Int,
        perPage: Int,
        items: List<User>
    ): None {
        val start: Long = page.toLong() * perPage
        val entityList = items.withIndex().map { item ->
            item.value.toEntity(query = query, index = start.plus(item.index))
        }
        userDao.insertAll(entityList)
        return None
    }

    override suspend fun getUserList(query: String): DomainListModel<BookmarkUser> {
        return userDao.getAll(query).let(BookmarkUserEntityListMapper::mapDomainList)
    }

    override suspend fun getUser(id: Long): BookmarkUser {
        return userDao.getUser(id)?.let(BookmarkUserEntityMapper::mapDomain)
            ?: throw IllegalStateException("$id User Not Found!")
    }

    override suspend fun deleteUserListByQuery(query: String): None {
        userDao.clear(query)
        return None
    }

    override suspend fun addBookmark(id: Long): None {
        val entity = BookmarkEntity(
            id = id,
            updateTimeStamp = System.currentTimeMillis()
        )
        bookmarkDao.insert(entity)
        return None
    }

    override suspend fun deleteBookmark(id: Long): None {
        bookmarkDao.delete(id)
        return None
    }

    override suspend fun getRemoteKey(query: String): RemoteKey {
        val key = remoteKeyDao.getNextKey(query)?.let(RemoteKeyEntityMapper::mapDomain)
        return key ?: RemoteKey(
            query = query,
            nextPage = 1,
            endOfPaginationReached = false
        )
    }

    override suspend fun deleteRemoteKey(query: String): None {
        remoteKeyDao.delete(query)
        return None
    }

    override suspend fun updateRemoteKey(query: RemoteKey): None {
        val entity = query.toEntity()
        remoteKeyDao.insert(entity)
        return None
    }
}
