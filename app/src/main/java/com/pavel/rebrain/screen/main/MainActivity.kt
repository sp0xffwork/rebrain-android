package com.pavel.rebrain.screen.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.pavel.rebrain.R
import com.pavel.rebrain.screen.base.BaseActivity
import com.pavel.rebrain.screen.base.BaseFragment
import com.pavel.rebrain.screen.main.tabs.FavoritesTabFragment
import com.pavel.rebrain.screen.main.tabs.MainTabFragment
import com.pavel.rebrain.screen.view.BottomBar
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Главный экран приложения
 */
class MainActivity : BaseActivity("MainActivity"), OnFragmentInteractionListener {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            bottomBar.setCheckedButton(BottomBar.MainTabType.MAIN)
            setFragment(MainTabFragment.newInstance())
        }

        bottomBar.setOnTabClickListener(BottomBar.MainTabType.MAIN) {
            setFragment(MainTabFragment.newInstance())
        }

        bottomBar.setOnTabClickListener(BottomBar.MainTabType.FAVORITES) {
            setFragment(FavoritesTabFragment.newInstance())
        }
    }

    private fun setFragment(fragment: BaseFragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment, fragment.getFragmentTag())
            .commit()
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented")
    }

}
