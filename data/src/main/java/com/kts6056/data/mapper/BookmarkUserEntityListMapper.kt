package com.kts6056.data.mapper

import com.kts6056.data.model.entity.BookmarkUserEntity
import com.kts6056.domain.DomainListModel
import com.kts6056.domain.model.BookmarkUser

internal object BookmarkUserEntityListMapper : ListMapper<BookmarkUserEntity, BookmarkUser> {
    override fun mapDomainList(input: List<BookmarkUserEntity>): DomainListModel<BookmarkUser> {
        return input.mapDomainList { item -> BookmarkUserEntityMapper.mapDomain(item) }
    }
}
