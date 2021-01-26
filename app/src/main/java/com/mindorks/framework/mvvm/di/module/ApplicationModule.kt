package com.mindorks.framework.mvvm.di.module

import android.util.Log
import com.google.gson.GsonBuilder
import com.mindorks.framework.mvvm.data.api.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * @author a.v.davtyan
 */
@Module(includes = [ViewModelModule::class])
class ApplicationModule {

    companion object {
        private const val BASE_URL = "https://gitlab.65apps.com/"
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val logging =
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient().newBuilder()
                    //.addInterceptor(TokenInterceptor())
                    .addInterceptor(logging)
                    .build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
//
//    class TokenInterceptor : Interceptor {
//
//        override fun intercept(chain: Interceptor.Chain): Response {
//            var original = chain.request()
//            val url = original.url.newBuilder()
//                .addQueryParameter(API_KEY, API_KEY_VALUE).build()
//            original = original.newBuilder().url(url).build()
//            Log.e("MovieDBApp", "intercept: ${original.url}")
//            return chain.proceed(original)
//        }
//    }

    @Singleton
    @Provides
    fun provideRetrofitService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
