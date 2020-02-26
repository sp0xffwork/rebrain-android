package com.pavel.rebrain.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.pavel.rebrain.api.products.Api
import com.pavel.rebrain.di.scope.PerApplication
import com.pavel.rebrain.di.util.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named

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
    fun provideRetrofit(okHttpClient: OkHttpClient, @Named(Constants.NAMED_BASE_URL) baseUrl: String): Retrofit {
        val gson: Gson = GsonBuilder()
            .setPrettyPrinting()
            .create()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
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