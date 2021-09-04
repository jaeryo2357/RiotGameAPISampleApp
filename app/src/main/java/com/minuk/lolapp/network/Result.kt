package com.minuk.lolapp.network

import java.lang.Exception

sealed class Result<T> {

    class Success<T> (date: T): Result<T>()

    class Error<T>(
        exception: Exception? = null,
        message: String? = null
    ): Result<T>()
}