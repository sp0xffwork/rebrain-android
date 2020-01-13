package com.pavel.rebrain.di.component

import com.pavel.rebrain.di.module.AppAuthStorageModule
import com.pavel.rebrain.di.module.AppModule
import com.pavel.rebrain.di.module.PreferenceHelperModule
import com.pavel.rebrain.di.module.ProductModeStorageModule
import com.pavel.rebrain.di.scope.PerApplication
import dagger.Component

/**
 * компонент приложения - главный узел
 */
@Component(modules = [AppModule::class, PreferenceHelperModule::class, ProductModeStorageModule::class, AppAuthStorageModule::class])
@PerApplication
interface AppComponent {
    fun splashActivityComponent(): SplashActivityComponent
    fun mainTabFragmentComponent(): MainTabFragmentComponent
}
