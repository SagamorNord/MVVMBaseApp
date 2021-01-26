package com.mindorks.framework.mvvm.di.module

import com.mindorks.framework.mvvm.ui.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author a.v.davtyan
 */
@Module
interface ActivityBindingModule {

    @ContributesAndroidInjector
    fun bindItemDetailActivity(): MainActivity?

}
