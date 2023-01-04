package com.kts6056.domain

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatcherProvider {
    val dispatcherDefault: CoroutineDispatcher
    val dispatcherIO: CoroutineDispatcher
    val dispatcherMain: CoroutineDispatcher
}
