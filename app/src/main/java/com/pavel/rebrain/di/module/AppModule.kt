package com.pavel.rebrain.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * будет хранить контекст приложения
 */
@Module
class AppModule(val context: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context = context

}