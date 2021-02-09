package com.mindorks.framework.mvvm.ui.main.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mindorks.framework.mvvm.data.model.EmployeeModel
import com.mindorks.framework.mvvm.data.repository.MainRepository
import com.mindorks.framework.mvvm.utils.Resource
import com.mindorks.framework.mvvm.data.db.model.SpecialtyModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val users = MutableLiveData<Resource<List<EmployeeModel>>>()
    private val specialities = MutableLiveData<Resource<List<SpecialtyModel>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        loadSpecialities()
    }

    @SuppressLint("CheckResult")
    private fun loadSpecialities() {
        fetchUsers()
            ?.map { item -> item.specialty }
            ?.collectInto(arrayListOf(), { l: ArrayList<SpecialtyModel>, i -> l.addAll(i) })
            ?.filter { it.isNotEmpty() }
            ?.map { list -> list.distinctBy { it.specialty_id } }
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                { list -> specialities.postValue(Resource.success(list)) },
                { specialities.postValue(Resource.error("Something Went Wrong", null)) })
    }

    private fun fetchUsers(): Observable<EmployeeModel>? {
        users.postValue(Resource.loading(null))
        //compositeDisposable.add(observable)

        return mainRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .map { result -> result.employees }
            .flatMap { list ->
                Observable.fromIterable(list)
            }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getUsers(): LiveData<Resource<List<EmployeeModel>>> {
        return users
    }

    fun getSpecialities(): LiveData<Resource<List<SpecialtyModel>>> {
        return specialities
    }
}
