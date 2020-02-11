package com.pavel.rebrain.di.component

import com.pavel.rebrain.di.scope.PerScreen
import com.pavel.rebrain.screen.main.tabs.FavoritesTabFragment
import dagger.Subcomponent

/**
 * компонент фрагмента вкладки favorites
 */
@Subcomponent()
@PerScreen
interface FavoritesTabFragmentComponent {
    fun inject(fragment: FavoritesTabFragment)
}