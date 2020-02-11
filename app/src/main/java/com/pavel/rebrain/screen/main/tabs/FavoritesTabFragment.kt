package com.pavel.rebrain.screen.main.tabs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.pavel.rebrain.App
import com.pavel.rebrain.R
import com.pavel.rebrain.screen.base.BaseFragment
import com.pavel.rebrain.screen.main.OnFragmentInteractionListener
import com.pavel.rebrain.screen.main.list.FavoritesRecyclerViewAdapter
import com.pavel.rebrain.viewmodel.FavoritesViewModel
import com.pavel.rebrain.viewmodel.FavoritesViewModelFactory
import kotlinx.android.synthetic.main.fragment_favorites_tab.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import org.jetbrains.anko.support.v4.toast
import timber.log.Timber
import javax.inject.Inject


/**
 * FavoritesTabFragment
 * показывает вкладку с избранным
 */
class FavoritesTabFragment : BaseFragment("FavoritesTabFragment") {
    private var listener: OnFragmentInteractionListener? = null

    private val adapter = FavoritesRecyclerViewAdapter { id ->
        toast("$id")
        favoritesViewModel.removeFavorite(id)
    }

    private lateinit var favoritesViewModel: FavoritesViewModel
    @Inject
    lateinit var factory: FavoritesViewModelFactory

    companion object {
        const val fragmentTag = "FavoritesTabFragment"
        fun newInstance() = FavoritesTabFragment()
    }

    override fun getFragmentTag(): String {
        return fragmentTag
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoritesViewModel =
            ViewModelProviders.of(this, factory).get(FavoritesViewModel::class.java)

        favoritesViewModel.favoritesList.observe(this, Observer { products ->
            swipeRefreshLayout.isRefreshing = false
            adapter.setFoodList(products)
        })

        initToolbar()
        val isNeedRefresh = (savedInstanceState == null)
        initRv(isNeedRefresh)
        initSwipeToRefresh()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }

        val appComponent = App.instance.appComponent

        val favoritesTabFragmentComponent =
            appComponent.favoritesTabFragmentComponent()
        favoritesTabFragmentComponent.inject(this)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    private fun initToolbar() {
        toolbar.title = getString(R.string.app_name)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
    }

    private fun initRv(isNeedRefresh: Boolean) {
        Timber.tag(App.APP_LOG_TAG).i("$logTitle.initRv")
        recyclerView.layoutManager = LinearLayoutManager(activity)
        swipeRefreshLayout.isRefreshing = true
        favoritesViewModel.requestFavorites(isNeedRefresh)
        recyclerView.adapter = adapter
    }

    private fun initSwipeToRefresh() {
        swipeRefreshLayout.setOnRefreshListener {
            favoritesViewModel.requestFavorites(true)
        }
    }

}
