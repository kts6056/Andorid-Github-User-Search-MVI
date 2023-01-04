package com.kts6056.domain.model

import com.kts6056.domain.DomainModel

data class RemoteKey(
    val query: String,
    val nextPage: Int,
    val endOfPaginationReached: Boolean
) : DomainModel
