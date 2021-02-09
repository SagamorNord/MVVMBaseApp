package com.sagamore.testapplication.feature_main_list

import com.mindorks.framework.mvvm.ui.main.ItemListView

/**
 * @author a.v.davtyan
 */
class ItemListPresenter(private val view: ItemListView) {
//
//    var retrofit: Retrofit
//    var apiService: ApiService
//
//    init {
//        val logging = HttpLoggingInterceptor()
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
//
//        val gson = GsonBuilder()
//            .setLenient()
//            .create()
//        retrofit = Retrofit.Builder()
//            .baseUrl(ItemListActivity.BASE_URL)
//            .client(
//                OkHttpClient().newBuilder().addNetworkInterceptor { chain ->
//                    val original: Request = chain.request()
//                    Log.i("11111", "intercept: ${chain.request().url}")
//                    chain.proceed(original);
//                }
//                    .addInterceptor(logging)
//                    .build()
//            )
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//        apiService = retrofit.create(ApiService::class.java)
//    }
//
//    @SuppressLint("CheckResult")
//    @RequiresApi(Build.VERSION_CODES.N)
//    private fun callEndpoints(): Observable<EmployeeModel>? {
//
//        val observable: Observable<EmployeeResponse> = apiService.loadList()
//
//        return observable
//            .subscribeOn(Schedulers.io())
//            .map { result -> result.employees }
//            .flatMap { list ->
//                Observable.fromIterable(list)
//            }
//    }
//
//    @SuppressLint("CheckResult")
//    @RequiresApi(Build.VERSION_CODES.N)
//    internal fun loadSpecialities() {
//        val specialities = callEndpoints()
//            ?.map { item -> item.specialty }
//            ?.collectInto(arrayListOf(), { l: ArrayList<SpecialtyModel>, i -> l.addAll(i) })
//            ?.blockingGet()
//
//        val specialitiesSet = setOf(specialities)
//
//        Observable.fromIterable(specialitiesSet)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { list ->
//                    if (list?.isNotEmpty() == true) {
//                        list.distinctBy { it.specialty_id }
//                        view.onDataLoaded(list.distinctBy { it.specialty_id })
//                    } else {
//                        view.onNotFound()
//                    }
//                },
//                { throwable ->
//                    view.onError(throwable)
//                    Log.e("11111", "handleError: ${throwable.stackTrace}")
//                })
//    }
//
//    @SuppressLint("CheckResult")
//    @RequiresApi(Build.VERSION_CODES.N)
//    internal fun loadEmployees(specId: Int) {
//        callEndpoints()
//            ?.observeOn(AndroidSchedulers.mainThread())
//            ?.filter { model -> model.specialty[0].specialty_id == specId }
//            ?.collectInto(arrayListOf(), { l: ArrayList<EmployeeModel>, i -> l.add(i) })
//            ?.subscribe({
//                view.onEmployeeLoaded(it)
//            },
//                { throwable ->
//                    view.onError(throwable)
//                    Log.e("11111", "handleError: ${throwable.stackTrace}")
//                })
//    }
}
