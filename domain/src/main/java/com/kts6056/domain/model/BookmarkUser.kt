package com.kts6056.domain.model

import com.kts6056.domain.DomainModel

data class BookmarkUser(
    val id: Long,
    val name: String,
    val profileUrl: String,
    val webUrl: String,
    val hasBookmark: Boolean
) : DomainModel
