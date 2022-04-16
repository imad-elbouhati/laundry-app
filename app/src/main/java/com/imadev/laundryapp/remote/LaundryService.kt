package com.imadev.laundryapp.remote

import com.imadev.laundryapp.remote.data.CategoriesResponse
import retrofit2.Response
import retrofit2.http.GET

interface LaundryService {

    @GET("categories")
    suspend fun getCategories(): CategoriesResponse

}