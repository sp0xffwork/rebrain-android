package com.pavel.rebrain.di.module

import android.content.Context
import com.pavel.rebrain.util.PreferenceHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * будет создавать имплементацию PreferenceHelper
 */
@Module
class PreferenceHelperModule {

    @Provides
    @Singleton
    fun providePreferenceHelper(context: Context): PreferenceHelper =
        PreferenceHelper(context)

}