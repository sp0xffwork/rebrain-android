package com.pavel.rebrain.screen.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
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

    enum class FragmentType(val tag: String) {
        MAIN("MainTabFragment"),
        FAVORITES("FavoritesTabFragment")
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomBar.setOnTabClickListener(BottomBar.MainTabType.MAIN) {
            setFragment(FragmentType.MAIN)
        }

        bottomBar.setOnTabClickListener(BottomBar.MainTabType.FAVORITES) {
            setFragment(FragmentType.FAVORITES)
        }

        if (savedInstanceState == null) {
            // при запуске всегда активным будет MAIN
            bottomBar.setCheckedButton(BottomBar.MainTabType.MAIN)
            setFragment(FragmentType.MAIN)
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        // при повороте экрана активный будет определяться автоматически из сохраненного состояния активити
        // чтобы выделить активную кнопку, надо определить, какой фагмент активен
        val currentFragment = supportFragmentManager.findFragmentById(R.id.container)
        currentFragment?.let {
            when ((it as? BaseFragment)?.getFragmentTag()) {
                MainTabFragment.fragmentTag -> bottomBar.setCheckedButton(BottomBar.MainTabType.MAIN)
                FavoritesTabFragment.fragmentTag -> bottomBar.setCheckedButton(BottomBar.MainTabType.FAVORITES)
            }
        }
    }

    private fun setFragment(type: FragmentType) {
        val fragments = supportFragmentManager.fragments
        for (fragment: Fragment in fragments) {
            if (fragment is BaseFragment && (fragment.getFragmentTag() == "MainTabFragment" || fragment.getFragmentTag() == "FavoritesTabFragment")) {
                supportFragmentManager.beginTransaction().detach(fragment).commit()
            }
        }
        val fragment = getFragment(type)
        putFragment(type, fragment)
    }

    /**
     * извлекаем фрагмент з FragmentManager или создаем новый, если он не был сохранен
     */
    private fun getFragment(type: FragmentType): BaseFragment {

        val fragment = supportFragmentManager.findFragmentByTag(type.tag) as BaseFragment?
        return fragment ?: when (type) {
            FragmentType.MAIN -> MainTabFragment.newInstance()
            FragmentType.FAVORITES -> FavoritesTabFragment.newInstance()
        }
    }

    /**
     * добавляет или аттачит фрагмент
     */
    private fun putFragment(type: FragmentType, fragment: BaseFragment) {
        val isFragmentAdded = supportFragmentManager.findFragmentByTag(type.tag) != null
        supportFragmentManager.beginTransaction().apply {
            if (!isFragmentAdded) {
                add(R.id.container, fragment, fragment.getFragmentTag())
            } else {
                attach(fragment)
            }
        }.commit()
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented")
    }

    override fun onBackPressed() {
        safeExit()
    }

    private fun safeExit() {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.dialog_exit_title))
            .setMessage(getString(R.string.dialog_exit_message))
            .setNegativeButton(getString(R.string.dialog_button_cancel), null)
            .setPositiveButton(getString(R.string.dialog_button_yes)) { _, _ ->
                finish()
            }
            .create()
            .show()
    }
}
