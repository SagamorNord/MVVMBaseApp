package com.mindorks.framework.mvvm.ui.main

import com.mindorks.framework.mvvm.data.model.EmployeeModel
import com.mindorks.framework.mvvm.data.db.model.SpecialtyModel

interface ItemListView {

    fun onDataLoaded(list: List<SpecialtyModel>)

    fun onEmployeeLoaded(list: List<EmployeeModel>)

    fun onNotFound()

    fun onError(t: Throwable)
}
