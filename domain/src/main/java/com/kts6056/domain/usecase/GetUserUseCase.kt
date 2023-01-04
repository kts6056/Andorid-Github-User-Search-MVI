package com.kts6056.domain.usecase

import com.kts6056.domain.CoroutineDispatcherProvider
import com.kts6056.domain.model.BookmarkUser
import com.kts6056.domain.repository.SearchRepository

class GetUserUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val searchRepository: SearchRepository
) : IOUseCase<GetUserUseCase.Params, BookmarkUser>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Params): BookmarkUser {
        return searchRepository.getUser(params.id)
    }

    @JvmInline
    value class Params(val id: Long)
}
