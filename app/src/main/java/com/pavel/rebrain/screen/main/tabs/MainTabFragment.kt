package com.pavel.rebrain.screen.main.tabs

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pavel.rebrain.App
import com.pavel.rebrain.R
import com.pavel.rebrain.screen.base.BaseFragment
import com.pavel.rebrain.screen.main.OnFragmentInteractionListener
import com.pavel.rebrain.screen.main.list.FoodListRecyclerViewAdapter
import com.pavel.rebrain.viewmodel.ProductListViewModel
import kotlinx.android.synthetic.main.fragment_main_tab.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import org.jetbrains.anko.support.v4.toast
import timber.log.Timber


/**
 * MainTabFragment
 * показывает карусель
 */
class MainTabFragment : BaseFragment("MainTabFragment") {

    private var listener: OnFragmentInteractionListener? = null
    private lateinit var adapter: FoodListRecyclerViewAdapter
    private lateinit var productListViewModel: ProductListViewModel

    private var mode = FoodListRecyclerViewAdapter.TableMode.LIST

    override fun getFragmentTag(): String {
        return "MainTabFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productListViewModel = ViewModelProviders.of(this).get(ProductListViewModel::class.java)

        initToolbar()
        initRv()
        initSwipeToRefresh()
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_tab, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_button -> {
                mode = if (mode == FoodListRecyclerViewAdapter.TableMode.GRID) {
                    FoodListRecyclerViewAdapter.TableMode.LIST
                } else {
                    FoodListRecyclerViewAdapter.TableMode.GRID
                }
                changeMenuIcon(item)
                setAdapterMode()
            }
        }
        return true
    }

    private fun initToolbar() {
        toolbar.title = "FoodApp"
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        setHasOptionsMenu(true)
    }

    private fun changeMenuIcon(item: MenuItem) {
        val iconResId = when (mode) {
            FoodListRecyclerViewAdapter.TableMode.LIST -> R.drawable.ic_menu_grid
            FoodListRecyclerViewAdapter.TableMode.GRID -> R.drawable.ic_menu_list
        }
        item.setIcon(iconResId)
    }

    private fun initRv() {
        Timber.tag(App.APP_LOG_TAG).i("$logTitle.initRv")
        adapter = FoodListRecyclerViewAdapter(productListViewModel.getProducts()) { id ->
            toast("$id")
        }
        recyclerView.adapter = adapter
        setAdapterMode()
    }

    private fun setAdapterMode() {

        while (recyclerView.itemDecorationCount > 0) {
            recyclerView.removeItemDecorationAt(0)
        }

        if (mode == FoodListRecyclerViewAdapter.TableMode.GRID) {
            recyclerView.layoutManager = GridLayoutManager(activity, 2)
            // todo: добавить перевод spacing из dp -> px
            recyclerView.addItemDecoration(
                GridSpacingItemDecoration(
                    2,
                    resources.getDimensionPixelOffset(R.dimen.grid_element_spacing),
                    true
                )
            )
        } else {
            recyclerView.layoutManager = LinearLayoutManager(activity)
        }

        recyclerView.adapter = adapter
        adapter.setTabledMode(mode)
    }

    private fun initSwipeToRefresh() {
        swipeRefreshLayout.setOnRefreshListener {
            // эмуляция ожидания загрузки
            Handler().postDelayed({
                adapter.setFoodList(productListViewModel.getProducts())
                swipeRefreshLayout.isRefreshing = false
            }, 2000)
        }
    }

    companion object {
        fun newInstance() =
            MainTabFragment()
    }
}


class GridSpacingItemDecoration(
    private val spanCount: Int,
    private val spacing: Int,
    private val includeEdge: Boolean
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view) // item position
        val column = position % spanCount // item column

        if (includeEdge) {
            outRect.left =
                spacing - column * spacing / spanCount // spacing - column * ((1f / spanCount) * spacing)
            outRect.right =
                (column + 1) * spacing / spanCount // (column + 1) * ((1f / spanCount) * spacing)

            if (position < spanCount) { // top edge
                outRect.top = spacing
            }
            outRect.bottom = spacing // item bottom
        } else {
            outRect.left = column * spacing / spanCount // column * ((1f / spanCount) * spacing)
            outRect.right =
                spacing - (column + 1) * spacing / spanCount // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            if (position >= spanCount) {
                outRect.top = spacing // item top
            }
        }
    }
}