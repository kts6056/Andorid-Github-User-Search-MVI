package com.kts6056.domain.datasource

import com.kts6056.domain.DomainListModel
import com.kts6056.domain.None
import com.kts6056.domain.model.LoadType
import com.kts6056.domain.model.BookmarkUser
import com.kts6056.domain.model.PagingResult

interface SearchDataSource {
    suspend fun fetchSearchUser(query: String, loadType: LoadType): PagingResult<DomainListModel<BookmarkUser>>
    suspend fun updateBookmark(id: Long, hasBookmark: Boolean): None
    suspend fun getUser(id: Long): BookmarkUser
}
