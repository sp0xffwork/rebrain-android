package com.pavel.rebrain.screen.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
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

        val fragmentMain: BaseFragment
        val fragmentFavorites: BaseFragment

        if (savedInstanceState == null) {
            fragmentMain = MainTabFragment.newInstance()
            fragmentFavorites = FavoritesTabFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.container, fragmentMain, fragmentMain.getFragmentTag())
                .commit()
            supportFragmentManager.beginTransaction()
                .add(R.id.container, fragmentFavorites, fragmentFavorites.getFragmentTag()).commit()
        } else {
            fragmentMain = supportFragmentManager.findFragmentByTag("MainTabFragment") as BaseFragment
            fragmentFavorites = supportFragmentManager.findFragmentByTag("FavoritesTabFragment") as BaseFragment
        }

        bottomBar.setOnTabClickListener(BottomBar.MainTabType.MAIN) {
            setFragment(fragmentMain)
        }

        bottomBar.setOnTabClickListener(BottomBar.MainTabType.FAVORITES) {
            setFragment(fragmentFavorites)
        }

        //todo сохранять какой фрагмент активен и восстанавливать при пересоздании activity
        bottomBar.setCheckedButton(BottomBar.MainTabType.MAIN)
        setFragment(fragmentMain)
    }

    private fun setFragment(fragment: BaseFragment) {
        val fragmentMain = supportFragmentManager.findFragmentByTag("MainTabFragment")
        val fragmentFavorites = supportFragmentManager.findFragmentByTag("FavoritesTabFragment")
        fragmentMain?.let { supportFragmentManager.beginTransaction().detach(it).commit() }
        fragmentFavorites?.let { supportFragmentManager.beginTransaction().detach(it).commit() }
        supportFragmentManager
            .beginTransaction()
            .attach(fragment)
            .commit()
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented")
    }

}
