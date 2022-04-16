package com.imadev.laundryapp.factory

import com.imadev.laundryapp.remote.data.CategoriesResponse
import com.imadev.laundryapp.remote.data.Category

object CategoriesFactory {

    fun categoryResponse() = CategoriesResponse(
        data = categories(),
        status = 200
    )


    private fun categories() = listOf(
        Category(1, "T-shirt"),
        Category(1, "Jellaba"),
        Category(1, "Takshita"),
        Category(1, "Jean"),
        Category(1, "T-shirt"),
        Category(1, "Jellaba"),
        Category(1, "Takshita"),
        Category(1, "Jean"),
        Category(1, "T-shirt"),
        Category(1, "Jellaba"),
        Category(1, "Takshita"),
        Category(1, "Jean"),
    )

}