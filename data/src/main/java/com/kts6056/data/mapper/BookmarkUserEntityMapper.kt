package com.kts6056.data.mapper

import com.kts6056.data.model.entity.BookmarkUserEntity
import com.kts6056.domain.model.BookmarkUser

internal object  BookmarkUserEntityMapper : Mapper<BookmarkUserEntity, BookmarkUser> {
    override fun mapDomain(input: BookmarkUserEntity): BookmarkUser = with(input){
        BookmarkUser(
            id = id,
            name = name,
            profileUrl = profileUrl,
            webUrl = webUrl,
            hasBookmark = hasBookmark
        )
    }
}
