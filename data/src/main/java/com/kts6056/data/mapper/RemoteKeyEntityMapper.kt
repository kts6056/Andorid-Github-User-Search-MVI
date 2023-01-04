package com.kts6056.data.mapper

import com.kts6056.data.model.entity.RemoteKeyEntity
import com.kts6056.domain.model.RemoteKey

internal object RemoteKeyEntityMapper : Mapper<RemoteKeyEntity, RemoteKey> {
    override fun mapDomain(input: RemoteKeyEntity): RemoteKey = with(input) {
        RemoteKey(
            query = query,
            nextPage = nextPage,
            endOfPaginationReached = endOfPaginationReached
        )
    }
}
