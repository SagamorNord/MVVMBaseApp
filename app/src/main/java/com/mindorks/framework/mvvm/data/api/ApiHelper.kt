package com.mindorks.framework.mvvm.data.api

import javax.inject.Inject

class ApiHelper @Inject constructor(private val apiService: ApiService) {

    fun getUsers() = apiService.loadList()

}
