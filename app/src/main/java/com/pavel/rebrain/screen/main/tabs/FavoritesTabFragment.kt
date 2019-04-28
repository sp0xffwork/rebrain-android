package com.pavel.rebrain.screen.main.tabs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pavel.rebrain.R
import com.pavel.rebrain.screen.base.BaseFragment
import com.pavel.rebrain.screen.main.OnFragmentInteractionListener


/**
 * FavoritesTabFragment
 * показывает вкладку с избранным
 */
class FavoritesTabFragment : BaseFragment("FavoritesTabFragment") {
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites_tab, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        val FRAGMENT_TAG = "FavoritesTabFragment"

        fun newInstance() =
            FavoritesTabFragment()
    }
}
