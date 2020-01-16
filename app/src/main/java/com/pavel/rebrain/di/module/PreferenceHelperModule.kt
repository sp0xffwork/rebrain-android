package com.pavel.rebrain.di.module

import android.content.Context
import com.pavel.rebrain.di.scope.PerApplication
import com.pavel.rebrain.util.PreferenceHelper
import dagger.Module
import dagger.Provides

/**
 * будет создавать имплементацию PreferenceHelper
 */
@Module
class PreferenceHelperModule {

    @Provides
    @PerApplication
    fun providePreferenceHelper(context: Context): PreferenceHelper =
        PreferenceHelper(context)

}