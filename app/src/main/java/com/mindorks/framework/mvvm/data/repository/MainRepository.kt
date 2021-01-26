package com.mindorks.framework.mvvm.data.repository

import com.mindorks.framework.mvvm.data.api.ApiHelper
import com.mindorks.framework.mvvm.data.model.EmployeeModel
import com.mindorks.framework.mvvm.data.model.User
import com.sagamore.testapplication.service.data.EmployeeResponse
import io.reactivex.Observable
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUsers(): Observable<EmployeeResponse> {
        return apiHelper.getUsers()
    }
}
