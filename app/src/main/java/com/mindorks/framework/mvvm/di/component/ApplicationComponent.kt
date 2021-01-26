package com.mindorks.framework.mvvm.di.component

import android.app.Application
import com.mindorks.framework.mvvm.app.BaseApplication
import com.mindorks.framework.mvvm.di.module.ActivityBindingModule
import com.mindorks.framework.mvvm.di.module.ApiHelperModule
import com.mindorks.framework.mvvm.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

/**
 * @author a.v.davtyan
 */

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, ActivityBindingModule::class, ApiHelperModule::class])
interface ApplicationComponent : AndroidInjector<DaggerApplication?> {

    fun inject(application: BaseApplication?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application?): Builder?
        fun build(): ApplicationComponent?
    }
}
