package com.pavel.rebrain.di.component

import com.pavel.rebrain.di.module.AppModule
import com.pavel.rebrain.di.module.ProductModeStorageModule
import com.pavel.rebrain.screen.main.tabs.MainTabFragment
import dagger.Component
import javax.inject.Singleton

/**
 * компонент фрагмента главной вкладки
 */
@Component(modules = [AppModule::class, ProductModeStorageModule::class])
@Singleton
interface MainTabFragmentComponent {

    fun inject(fragment: MainTabFragment)

}