package com.pavel.rebrain.di.module

import android.content.Context
import com.pavel.rebrain.domain.TableMode
import com.pavel.rebrain.repository.ProductModeStorage
import com.pavel.rebrain.repository.Storage
import com.pavel.rebrain.util.PreferenceHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * будет создавать имплементацию ProductModeStorage
 */
@Module
class ProductModeStorageModule {

    @Provides
    @Singleton
    fun provideStorage(context: Context): Storage<TableMode> =
        ProductModeStorage(PreferenceHelper(context))

}


