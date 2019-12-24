package com.pavel.rebrain.screen.base


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pavel.rebrain.App
import timber.log.Timber

/**
 * Base Fragment class.
 * Логирует жизненный цикл фрагмента.
 *
 */
abstract class BaseFragment(val logTitle: String) : Fragment() {

    abstract fun getFragmentTag(): String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.tag(App.APP_LOG_TAG).i("$logTitle.onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.tag(App.APP_LOG_TAG).i("$logTitle.onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.tag(App.APP_LOG_TAG).i("$logTitle.onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.tag(App.APP_LOG_TAG).i("$logTitle.onActivityCreated")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.tag(App.APP_LOG_TAG).i("$logTitle.onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Timber.tag(App.APP_LOG_TAG).i("$logTitle.onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag(App.APP_LOG_TAG).i("$logTitle.onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag(App.APP_LOG_TAG).i("$logTitle.onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag(App.APP_LOG_TAG).i("$logTitle.onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.tag(App.APP_LOG_TAG).i("$logTitle.onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag(App.APP_LOG_TAG).i("$logTitle.onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.tag(App.APP_LOG_TAG).i("$logTitle.onDetach")
    }

}
