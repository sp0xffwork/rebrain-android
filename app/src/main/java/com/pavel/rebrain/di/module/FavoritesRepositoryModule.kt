package com.pavel.rebrain.di.module

import com.pavel.rebrain.di.scope.PerApplication
import com.pavel.rebrain.repository.FavoritesRepository
import dagger.Module
import dagger.Provides

/**
 * будет создавать имплементацию FavoritesRepository
 */
@Module
class FavoritesRepositoryModule {

    @Provides
    @PerApplication
    fun provideRepository(): FavoritesRepository =
        FavoritesRepository()

}
