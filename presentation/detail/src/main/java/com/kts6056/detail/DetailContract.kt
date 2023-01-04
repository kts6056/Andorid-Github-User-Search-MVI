package com.kts6056.detail

import com.kts6056.core.mvi.ViewEffect
import com.kts6056.core.mvi.ViewIntent
import com.kts6056.core.mvi.ViewState

sealed interface DetailIntent : ViewIntent {
    @JvmInline
    value class Refresh(val id: Long) : DetailIntent

    @JvmInline
    value class BookmarkChanged(val hasBookmark: Boolean) : DetailIntent
}

data class DetailState(
    val id: Long = -1,
    val name: String = "",
    val profileUrl: String = "",
    val webUrl: String = "",
    val hasBookmark: Boolean = false
) : ViewState

object DetailEffect : ViewEffect
