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

    enum class FragmentType {
        Main, Favorites
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentMain: BaseFragment = getFragment(FragmentType.Main)
        val fragmentFavorites: BaseFragment = getFragment(FragmentType.Favorites)

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
        // извлекаем фрагменты из FragmentManager
        val fragmentMain = supportFragmentManager.findFragmentByTag("MainTabFragment")
        val fragmentFavorites = supportFragmentManager.findFragmentByTag("FavoritesTabFragment")

        // и detach их
        fragmentMain?.let { supportFragmentManager.beginTransaction().detach(it).commit() }
        fragmentFavorites?.let { supportFragmentManager.beginTransaction().detach(it).commit() }

        // ищем, был ли ранее добавлен fragment из аргумента
        val frag = supportFragmentManager.findFragmentByTag(fragment.getFragmentTag())
        supportFragmentManager.beginTransaction().apply {
            if (frag === null) {
                // если нет, то добавляем его
                add(R.id.container, fragment, fragment.getFragmentTag())
            } else {
                // если да, то attach его
                attach(fragment)
            }
        }.commit()
    }

    /**
     *  извлекаем фрагмент з FragmentManager или создаем новый, если он не был сохранен
     */
    private fun getFragment(type: FragmentType): BaseFragment {

        val tag = when (type) {
            FragmentType.Main -> "MainTabFragment"
            FragmentType.Favorites -> "FavoritesTabFragment"
        }

        val fragment = supportFragmentManager.findFragmentByTag(tag) as BaseFragment?
        return if (fragment !== null)
            fragment
        else
            when (type) {
                FragmentType.Main -> MainTabFragment.newInstance()
                FragmentType.Favorites -> FavoritesTabFragment.newInstance()
            }
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented")
    }

}
