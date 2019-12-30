package com.pavel.rebrain.di.component

import com.pavel.rebrain.di.scope.PerApplication
import dagger.Component

/**
 * компонент приложения - главный узел
 */
@Component()
@PerApplication
interface AppComponent
