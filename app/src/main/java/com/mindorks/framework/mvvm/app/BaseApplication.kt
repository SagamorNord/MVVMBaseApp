package com.mindorks.framework.mvvm.app

import android.util.Log
import com.mindorks.framework.mvvm.di.component.ApplicationComponent
import com.mindorks.framework.mvvm.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


/**
 * @author a.v.davtyan
 */
class BaseApplication: DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
        Log.d("MovieDBApp", "BaseApplication onCreate ")
    }

    override fun applicationInjector(): AndroidInjector<DaggerApplication?> {
        val component: ApplicationComponent? =
            DaggerApplicationComponent.builder().application(this)?.build()
        component?.inject(this)
        return component!!
    }
}
