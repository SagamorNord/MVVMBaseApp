package com.mindorks.framework.mvvm.di.qualifiers

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * @author a.v.davtyan
 */
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
