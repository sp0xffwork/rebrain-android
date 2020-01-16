package com.pavel.rebrain.di.component

import com.pavel.rebrain.di.scope.PerScreen
import com.pavel.rebrain.screen.main.tabs.MainTabFragment
import dagger.Subcomponent

/**
 * компонент фрагмента главной вкладки
 */
@Subcomponent()
@PerScreen
interface MainTabFragmentComponent {

    fun inject(fragment: MainTabFragment)

}