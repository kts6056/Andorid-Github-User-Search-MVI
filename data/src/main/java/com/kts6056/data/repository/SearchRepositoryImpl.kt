package com.kts6056.data.repository

import com.kts6056.domain.DomainListModel
import com.kts6056.domain.None
import com.kts6056.domain.datasource.SearchDataSource
import com.kts6056.domain.model.BookmarkUser
import com.kts6056.domain.model.LoadType
import com.kts6056.domain.model.PagingResult
import com.kts6056.domain.repository.SearchRepository
import javax.inject.Inject

internal class SearchRepositoryImpl @Inject constructor(
    private val searchDataSource: SearchDataSource
) : SearchRepository {
    override suspend fun fetchSearchUser(
        query: String,
        loadType: LoadType
    ): PagingResult<DomainListModel<BookmarkUser>> {
        return searchDataSource.fetchSearchUser(query, loadType)
    }

    override suspend fun updateBookmark(id: Long, hasBookmark: Boolean): None {
        return searchDataSource.updateBookmark(id, hasBookmark)
    }

    override suspend fun getUser(id: Long): BookmarkUser {
        return searchDataSource.getUser(id)
    }
}
