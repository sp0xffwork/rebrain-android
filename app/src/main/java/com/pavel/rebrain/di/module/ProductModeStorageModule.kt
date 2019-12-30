package com.pavel.rebrain.di.module

import android.content.Context
import com.pavel.rebrain.di.scope.PerScreen
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
    @PerScreen
    fun provideStorage(context: Context): Storage<TableMode> =
        ProductModeStorage(PreferenceHelper(context))

}


