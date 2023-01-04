package com.kts6056.domain.usecase

import com.kts6056.domain.CoroutineDispatcherProvider
import com.kts6056.domain.DomainModel
import com.kts6056.domain.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class UseCase<P, R : DomainModel> {

    protected abstract fun execute(params: P): R

    operator fun invoke(params: P) = try {
        Result.Success(execute(params))
    } catch (e: Exception) {
        Result.Failure(e)
    }
}

abstract class CoroutineUseCase<P, R : DomainModel>(private val dispatcher: CoroutineDispatcher) {

    protected abstract suspend fun execute(params: P): R

    suspend operator fun invoke(params: P): Result<R> = withContext(dispatcher) {
        try {
            Result.Success(execute(params))
        } catch (e: Exception) {
            Result.Failure(e)
        }
    }
}

abstract class IOUseCase<P, R : DomainModel>(
    coroutineDispatcherProvider: CoroutineDispatcherProvider
) : CoroutineUseCase<P, R>(coroutineDispatcherProvider.dispatcherIO)
