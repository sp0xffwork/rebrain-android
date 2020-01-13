package com.pavel.rebrain.di.module

import com.pavel.rebrain.di.scope.PerApplication
import com.pavel.rebrain.repository.AppAuthStorage
import com.pavel.rebrain.repository.Storage
import com.pavel.rebrain.util.PreferenceHelper
import dagger.Module
import dagger.Provides

/**
 * будет создавать имплементацию AppAuthStorage
 */
@Module
class AppAuthStorageModule {

    @Provides
    @PerApplication
    fun provideStorage(preferenceHelper: PreferenceHelper): Storage<Boolean> =
        AppAuthStorage(preferenceHelper)

}