package com.pavel.rebrain.di.component

import dagger.Component
import javax.inject.Singleton

/**
 * компонент приложения - главный узел
 */
@Component()
@Singleton
interface AppComponent {

    // не знаю для чего мы это делали, но пока что оно не понадобилось
    //fun preferenceHelper(): PreferenceHelper
    //fun applicationContext(): Context
    //fun productModeStorage(): Storage<TableMode>

}
