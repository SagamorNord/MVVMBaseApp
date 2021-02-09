package com.mindorks.framework.mvvm.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mindorks.framework.mvvm.data.api.ApiHelper
import com.mindorks.framework.mvvm.data.repository.MainRepository
import com.mindorks.framework.mvvm.ui.listing.viewmodel.ListingViewModel
import com.mindorks.framework.mvvm.ui.main.viewmodel.MainViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        // TODO Удалить
        if (modelClass.isAssignableFrom(ListingViewModel::class.java)) {
            return ListingViewModel(MainRepository(apiHelper)) as T
        }
        else if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}
