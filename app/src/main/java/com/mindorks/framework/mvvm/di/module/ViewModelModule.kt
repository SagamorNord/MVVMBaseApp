package com.mindorks.framework.mvvm.di.module

import androidx.lifecycle.ViewModel
import com.mindorks.framework.mvvm.ui.listing.viewmodel.ListingViewModel
import com.mindorks.framework.mvvm.di.qualifiers.ViewModelKey
import com.mindorks.framework.mvvm.ui.main.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author a.v.davtyan
 */
@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListingViewModel::class)
    fun bindListingViewModel(viewModel: ListingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
