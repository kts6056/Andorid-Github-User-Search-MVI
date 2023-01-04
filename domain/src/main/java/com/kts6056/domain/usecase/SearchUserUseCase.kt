package com.kts6056.domain.usecase

import com.kts6056.domain.CoroutineDispatcherProvider
import com.kts6056.domain.DomainListModel
import com.kts6056.domain.model.BookmarkUser
import com.kts6056.domain.model.LoadType
import com.kts6056.domain.model.PagingResult
import com.kts6056.domain.repository.SearchRepository

class SearchUserUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val searchRepository: SearchRepository
) : IOUseCase<SearchUserUseCase.Params, PagingResult<DomainListModel<BookmarkUser>>>(
    coroutineDispatcherProvider
) {
    override suspend fun execute(
        params: Params
    ): PagingResult<DomainListModel<BookmarkUser>> = with(params) {
        return searchRepository.fetchSearchUser(query, loadType)
    }

    data class Params(
        val query: String,
        val loadType: LoadType
    )
}
