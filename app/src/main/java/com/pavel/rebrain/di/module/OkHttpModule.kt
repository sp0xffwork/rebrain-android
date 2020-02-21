package com.pavel.rebrain.di.module

import com.pavel.rebrain.App
import com.pavel.rebrain.di.scope.PerApplication
import com.pavel.rebrain.di.util.Constants
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import timber.log.Timber
import javax.inject.Named

/**
 * будет создавать имплементацию OkHttp
 */
@Module
class OkHttpModule {
    /**
     * предоставляет объект OkHttpClient
     */
    @Provides
    @PerApplication
    fun provideOkHttp(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(LogInterceptor())
        .build()

    /**
     * предоставляет base url
     */
    @Provides
    @Named(Constants.NAMED_BASE_URL)
    @PerApplication
    fun provideBaseUrl(): String = "http://api.android.srwx.net/api/v2/"

    /**
     * интерцептор запросов к api для логирования
     */
    class LogInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            val response = chain.proceed(request)
            val body = response.body
            val code = response.code

            if (response.isSuccessful) {
                Timber.tag(App.APP_LOG_TAG).i("LogInterceptor response is: %s", body?.string())
            } else {
                Timber.tag(App.APP_LOG_TAG).i("LogInterceptor response error code is: %d", code)
            }

            return response
        }
    }
}