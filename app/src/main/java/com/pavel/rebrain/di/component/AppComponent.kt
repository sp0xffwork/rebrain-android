package com.pavel.rebrain.di.component

import com.pavel.rebrain.di.module.*
import com.pavel.rebrain.di.scope.PerApplication
import dagger.Component

/**
 * компонент приложения - главный узел
 */
@Component(
    modules = [
        AppModule::class,
        PreferenceHelperModule::class,
        ProductModeStorageModule::class,
        AppAuthStorageModule::class,
        FavoritesRepositoryModule::class,
        OkHttpModule::class
    ]
)
@PerApplication
interface AppComponent {
    fun splashActivityComponent(): SplashActivityComponent
    fun mainTabFragmentComponent(): MainTabFragmentComponent
    fun favoritesTabFragmentComponent(): FavoritesTabFragmentComponent
}
