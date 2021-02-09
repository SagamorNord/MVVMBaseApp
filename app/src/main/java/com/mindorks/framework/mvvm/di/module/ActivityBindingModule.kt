package com.mindorks.framework.mvvm.di.module

import com.mindorks.framework.mvvm.ui.listing.view.EmployeeListActivity
import com.mindorks.framework.mvvm.ui.main.MainListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author a.v.davtyan
 */
@Module
interface ActivityBindingModule {

    @ContributesAndroidInjector
    fun bindItemDetailActivity(): EmployeeListActivity?

    @ContributesAndroidInjector
    fun bindMainListActivity(): MainListActivity?

}
