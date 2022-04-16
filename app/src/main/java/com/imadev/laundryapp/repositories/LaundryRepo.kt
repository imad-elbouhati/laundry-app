package com.imadev.laundryapp.repositories

import com.imadev.laundryapp.remote.LaundryService
import com.imadev.laundryapp.utils.safeApiCall
import javax.inject.Inject

class LaundryRepo @Inject constructor(
    val laundryService: LaundryService
) {

    fun getCategories() = safeApiCall {
        laundryService.getCategories()
    }
}
