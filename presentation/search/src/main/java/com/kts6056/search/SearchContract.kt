package com.kts6056.search

import com.kts6056.core.mvi.ViewEffect
import com.kts6056.core.mvi.ViewIntent
import com.kts6056.core.mvi.ViewState
import com.kts6056.domain.model.BookmarkUser

sealed interface SearchIntent : ViewIntent {
    @JvmInline
    value class QueryChanged(val query: String) : SearchIntent
    object LoadMore : SearchIntent
    object Sync : SearchIntent
    data class BookmarkChanged(val id: Long, val hasBookmark: Boolean) : SearchIntent
}

data class SearchState(
    val query: String = "",
    val bookmarkUserList: List<BookmarkUser> = listOf(),
    val endOfPaginationReached: Boolean = false,
    val isLoading: Boolean = false
) : ViewState

sealed interface SearchEffect : ViewEffect {
    @JvmInline
    value class ShowToastMessageEffect(val message: String) : SearchEffect
}
