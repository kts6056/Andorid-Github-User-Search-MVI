package com.kts6056.domain

interface DomainModel
object None : DomainModel
data class DomainListModel<T : DomainModel>(val list: List<T>) : DomainModel
data class DomainTypeModel<T>(val value: T) : DomainModel
