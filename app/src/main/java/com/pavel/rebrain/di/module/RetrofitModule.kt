package com.pavel.rebrain.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.pavel.rebrain.api.products.Api
import com.pavel.rebrain.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * будет создавать имплементацию Retrofit
 */
@Module
class RetrofitModule {
    /**
     * предоставляет объект Retrofit
     */
    @Provides
    @PerApplication
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val gson: Gson = GsonBuilder()
            .setPrettyPrinting()
            .create()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://api.android.srwx.net/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    /**
     * предоставляет API
     */
    @Provides
    @PerApplication
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

}