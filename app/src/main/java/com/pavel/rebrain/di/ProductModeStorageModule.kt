package com.pavel.rebrain.di

import com.pavel.rebrain.domain.TableMode
import com.pavel.rebrain.repository.ProductModeStorage
import com.pavel.rebrain.repository.Storage
import com.pavel.rebrain.util.PreferenceHelper
import dagger.Module
import dagger.Provides

/**
 * будет создавать имплементацию ProductModeStorage
 */
@Module
class ProductModeStorageModule {

    @Provides
    fun provideStorage(preferenceHelper: PreferenceHelper): Storage<TableMode> =
        ProductModeStorage(preferenceHelper)

}


