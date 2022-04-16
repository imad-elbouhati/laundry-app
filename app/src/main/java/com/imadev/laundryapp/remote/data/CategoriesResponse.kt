package com.imadev.laundryapp.remote.data

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("0")
    val data: List<Category>?,
    val status: Int?
)

data class Category(
    val id: Int,
    @SerializedName("libelle")
    var label: String
)