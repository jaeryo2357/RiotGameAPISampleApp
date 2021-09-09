package com.minuk.lolapp.network

import java.lang.Exception

sealed class Result<T> {

    data class Success<T> (val date: T): Result<T>()

    data class Error<T>(
        val exception: Exception? = null,
        val message: String? = null
    ): Result<T>()
}