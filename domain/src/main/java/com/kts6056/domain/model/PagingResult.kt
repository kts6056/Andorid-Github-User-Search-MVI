package com.kts6056.domain.model

import com.kts6056.domain.DomainModel

sealed interface PagingResult<T : DomainModel> : DomainModel {
    // Error가 발생한 경우
    class Error<T : DomainModel>(
        val throwable: Throwable,
        val item: T
    ) : PagingResult<T>

    // Load가 끝난 경우
    class Success<T : DomainModel>(
        val endOfPaginationReached: Boolean,
        val item: T
    ) : PagingResult<T>
}
