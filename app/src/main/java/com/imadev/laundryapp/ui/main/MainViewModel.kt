package com.imadev.laundryapp.ui.main

import androidx.lifecycle.viewModelScope
import com.imadev.laundryapp.remote.data.CategoriesResponse
import com.imadev.laundryapp.repositories.LaundryRepo
import com.imadev.laundryapp.ui.base.BaseViewModel
import com.imadev.laundryapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: LaundryRepo
) : BaseViewModel() {

    private val _categories = MutableSharedFlow<Resource<Response<CategoriesResponse>>>()
    val categories = _categories

    fun getCategories() = repo.getCategories()
}