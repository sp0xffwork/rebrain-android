package com.pavel.rebrain.di

import android.content.Context
import com.pavel.rebrain.util.PreferenceHelper
import dagger.Module
import dagger.Provides

/**
 * будет создавать имплементацию PreferenceHelper
 */

@Module
class PreferenceHelperModule {

    @Provides
    fun providePreferenceHelper(context: Context): PreferenceHelper =
        PreferenceHelper(context)

}