package com.mindorks.framework.mvvm.data.repository

import com.mindorks.framework.mvvm.data.api.ApiHelper
import com.sagamore.testapplication.service.data.EmployeeResponse
import io.reactivex.Observable
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    fun getUsers(): Observable<EmployeeResponse> {
        return apiHelper.getUsers()
    }
}
