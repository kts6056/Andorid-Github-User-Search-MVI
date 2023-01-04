package com.kts6056.domain.datasource

import com.kts6056.domain.DomainListModel
import com.kts6056.domain.None
import com.kts6056.domain.model.BookmarkUser
import com.kts6056.domain.model.RemoteKey
import com.kts6056.domain.model.User

interface UserDataBase {
    suspend fun addUserList(query: String, page: Int, perPage: Int, items: List<User>): None
    suspend fun getUserList(query: String): DomainListModel<BookmarkUser>
    suspend fun getUser(id: Long): BookmarkUser
    suspend fun deleteUserListByQuery(query: String): None
    suspend fun addBookmark(id: Long): None
    suspend fun deleteBookmark(id: Long): None
    suspend fun getRemoteKey(query: String): RemoteKey
    suspend fun deleteRemoteKey(query: String): None
    suspend fun updateRemoteKey(query: RemoteKey): None
}
