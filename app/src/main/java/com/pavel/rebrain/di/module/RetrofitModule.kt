package com.pavel.rebrain.di.module

import com.pavel.rebrain.api.ApiAuth
import com.pavel.rebrain.api.ApiCart
import com.pavel.rebrain.api.ApiProducts
import com.pavel.rebrain.api.ApiUser
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
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    /**
     * предоставляет API Auth
     */
    @Provides
    @PerApplication
    fun provideApiAuh(retrofit: Retrofit): ApiAuth {
        return retrofit.create(ApiAuth::class.java)
    }

    /**
     * предоставляет API Cart
     */
    @Provides
    @PerApplication
    fun provideApiCart(retrofit: Retrofit): ApiCart {
        return retrofit.create(ApiCart::class.java)
    }

    /**
     * предоставляет API Products
     */
    @Provides
    @PerApplication
    fun provideApiProducts(retrofit: Retrofit): ApiProducts {
        return retrofit.create(ApiProducts::class.java)
    }

    /**
     * предоставляет API User
     */
    @Provides
    @PerApplication
    fun provideApiUser(retrofit: Retrofit): ApiUser {
        return retrofit.create(ApiUser::class.java)
    }

}