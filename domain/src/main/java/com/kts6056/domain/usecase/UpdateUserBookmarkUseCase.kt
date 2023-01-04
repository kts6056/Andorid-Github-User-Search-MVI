package com.kts6056.domain.usecase

import com.kts6056.domain.CoroutineDispatcherProvider
import com.kts6056.domain.None
import com.kts6056.domain.repository.SearchRepository

class UpdateUserBookmarkUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val searchRepository: SearchRepository
) : IOUseCase<UpdateUserBookmarkUseCase.Params, None>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Params): None = with(params) {
        return searchRepository.updateBookmark(id, hasBookmark)
    }

    data class Params(
        val id: Long,
        val hasBookmark: Boolean
    )
}
