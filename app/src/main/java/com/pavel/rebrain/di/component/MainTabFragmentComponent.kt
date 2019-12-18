package com.pavel.rebrain.di.component

import com.pavel.rebrain.di.module.ProductModeStorageModule
import com.pavel.rebrain.repository.ProductModeStorage
import dagger.Component
import javax.inject.Singleton

/**
 * компонент фрагмента главной вкладки
 */
@Component(modules = [ProductModeStorageModule::class])
@Singleton
interface MainTabFragmentComponent {

    fun productModeStorage(): ProductModeStorage

}