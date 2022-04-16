package com.imadev.laundryapp.utils

import android.util.Log
import kotlinx.coroutines.flow.flow
import retrofit2.Response



inline fun <T> safeApiCall(
    crossinline apiCall: suspend () -> T
) = flow {

    emit(Resource.Loading(null))

    try {
        emit(Resource.Success(apiCall.invoke()))
    } catch (throwable: Throwable) {
        emit(Resource.Error(throwable, null))
    }
}
