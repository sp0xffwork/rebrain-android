package com.pavel.rebrain.di.module

import android.content.Context
import com.pavel.rebrain.di.scope.PerApplication
import dagger.Module
import dagger.Provides

/**
 * будет хранить контекст приложения
 */
@Module
class AppModule(val context: Context) {

    @Provides
    @PerApplication
    fun provideContext(): Context = context

}