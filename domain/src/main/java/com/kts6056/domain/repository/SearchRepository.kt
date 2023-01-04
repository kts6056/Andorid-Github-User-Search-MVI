package com.kts6056.domain.repository

import com.kts6056.domain.DomainListModel
import com.kts6056.domain.None
import com.kts6056.domain.model.BookmarkUser
import com.kts6056.domain.model.LoadType
import com.kts6056.domain.model.PagingResult

interface SearchRepository {
    suspend fun fetchSearchUser(
        query: String,
        loadType: LoadType
    ): PagingResult<DomainListModel<BookmarkUser>>

    suspend fun updateBookmark(id: Long, hasBookmark: Boolean): None
    suspend fun getUser(id: Long): BookmarkUser
}
