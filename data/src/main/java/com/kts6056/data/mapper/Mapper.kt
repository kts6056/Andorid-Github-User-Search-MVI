package com.kts6056.data.mapper

import com.kts6056.data.model.DataModel
import com.kts6056.domain.DomainListModel
import com.kts6056.domain.DomainModel

internal fun interface Mapper<Data : DataModel, Domain : DomainModel> {
    fun mapDomain(input: Data): Domain
}

internal fun interface ListMapper<Data : DataModel, Domain : DomainModel> {
    fun mapDomainList(input: List<Data>): DomainListModel<Domain>
}

internal inline fun <Data : DataModel, Domain : DomainModel> List<Data>.mapDomainList(
    mapSingle: (Data) -> Domain
): DomainListModel<Domain> {
    return DomainListModel(map { mapSingle(it) })
}
