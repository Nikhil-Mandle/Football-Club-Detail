package com.nikhilproject.domain.common

import androidx.annotation.StringRes
import kotlinx.coroutines.flow.Flow


typealias FlowResult<T> = Flow<Result<T>>

sealed class Result<out T> {
    data class SuccessState<T>(val data: T) : Result<T>()
    data class ErrorState<T>(
        @StringRes val message: Int? = null,
        val responseMessage: String? = null
    ) : Result<T>()
}