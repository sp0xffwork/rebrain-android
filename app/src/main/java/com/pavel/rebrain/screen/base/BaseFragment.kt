package com.pavel.rebrain.screen.base


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import timber.log.Timber

/**
 * Base Gtagment class.
 *
 */
open class BaseFragment : Fragment() {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Timber.tag("FoodApp").i("Fragment.onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.tag("FoodApp").i("Fragment.onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.tag("FoodApp").i("Fragment.onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.tag("FoodApp").i("Fragment.onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Timber.tag("FoodApp").i("Fragment.onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag("FoodApp").i("Fragment.onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag("FoodApp").i("Fragment.onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag("FoodApp").i("Fragment.onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.tag("FoodApp").i("Fragment.onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag("FoodApp").i("Fragment.onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.tag("FoodApp").i("Fragment.onDetach")
    }

}
