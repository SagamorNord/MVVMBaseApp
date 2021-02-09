package com.mindorks.framework.mvvm.di.module

import com.mindorks.framework.mvvm.data.api.ApiHelper
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author a.v.davtyan
 */
@Module
interface ApiHelperModule {

    @ContributesAndroidInjector
    fun provideHelper(): ApiHelper?
}
