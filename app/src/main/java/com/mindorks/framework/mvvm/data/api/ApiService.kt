package com.mindorks.framework.mvvm.data.api

import com.mindorks.framework.mvvm.data.model.EmployeeModel
import com.sagamore.testapplication.service.data.EmployeeResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("movie/popular?")
    fun getUsers(): Single<List<EmployeeModel>>

    @GET("65gb/static/raw/master/testTask.json")
    fun loadList(): Observable<EmployeeResponse>
}
