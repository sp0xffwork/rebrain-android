package com.pavel.rebrain.di

import android.content.Context
import com.pavel.rebrain.App
import dagger.Module
import dagger.Provides

/**
 * будет хранить контекст приложения
 */
@Module
class AppModule {

    @Provides
    fun provideContext(app: App): Context = app

}