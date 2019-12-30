package com.pavel.rebrain.di.component

import com.pavel.rebrain.di.module.AppModule
import com.pavel.rebrain.di.module.ProductModeStorageModule
import com.pavel.rebrain.di.scope.PerScreen
import com.pavel.rebrain.screen.main.tabs.MainTabFragment
import dagger.Component

/**
 * компонент фрагмента главной вкладки
 */
@Component(modules = [AppModule::class, ProductModeStorageModule::class])
@PerScreen
interface MainTabFragmentComponent {

    fun inject(fragment: MainTabFragment)

}