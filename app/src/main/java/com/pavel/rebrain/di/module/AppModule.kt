package com.pavel.rebrain.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * будет хранить контекст приложения
 */
@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context = context

}