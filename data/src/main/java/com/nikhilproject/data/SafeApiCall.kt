package com.nikhilproject.data

import com.nikhilproject.domain.common.Constant.NETWORK_TIMEOUT
import com.nikhilproject.domain.common.Result
import com.nikhilproject.domain.exception.APIException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import java.io.IOException

object SafeApiCall {

    suspend fun <T> execute(
        dispatcher: CoroutineDispatcher,
        apiCall: suspend () -> T
    ): Result<T> {
        return withContext(dispatcher) {
            try {
                apiCall.run {
                    val networkData = safeApiCall(dispatcher, this)
                    Result.SuccessState(networkData)
                }
            } catch (throwable: Throwable) {
                return@withContext when (throwable) {
                    is TimeoutCancellationException -> Result.ErrorState(message = R.string.network_timeout)
                    is IOException -> Result.ErrorState(message = R.string.network_error)
                    else -> {
                        Result.ErrorState(message = R.string.something_went_wrong)
                    }
                }
            }
        }
    }


    private suspend fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher,
        apiCall: suspend () -> T
    ): T {
        return withContext(dispatcher) {
            try {
                withTimeout(NETWORK_TIMEOUT) {
                    apiCall()
                }
            } catch (throwable: TimeoutCancellationException) {
                throw APIException(genericError = R.string.network_timeout)
            }
        }
    }
}