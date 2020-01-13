package com.pavel.rebrain.di.component

import com.pavel.rebrain.di.scope.PerScreen
import dagger.Subcomponent

/**
 * компонент для MainActivity
 */
@Subcomponent()
@PerScreen
interface MainActivityComponent {
}