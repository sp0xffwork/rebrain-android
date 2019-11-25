package com.pavel.rebrain.screen.main.tabs

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pavel.rebrain.App
import com.pavel.rebrain.R
import com.pavel.rebrain.domain.TableMode
import com.pavel.rebrain.screen.base.BaseFragment
import com.pavel.rebrain.screen.main.OnFragmentInteractionListener
import com.pavel.rebrain.screen.main.list.FoodListRecyclerViewAdapter
import com.pavel.rebrain.viewmodel.ProductListViewModel
import com.pavel.rebrain.viewmodel.ProductListViewModelFactory
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
    private var optionsMenu: Menu? = null

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

        productListViewModel =
            ViewModelProviders.of(
                this,
                ProductListViewModelFactory(
                    App.instance.appRepository,
                    App.instance.appProductModeRepository
                )
            )
                .get(ProductListViewModel::class.java)

        productListViewModel.productList.observe(this, Observer { products ->
            swipeRefreshLayout.isRefreshing = false
            adapter.setFoodList(products)
        })

        productListViewModel.productsViewMode.observe(this, Observer { mode ->
            changeMenuIcon(mode)
            setAdapterMode(mode)
        })

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
        optionsMenu = menu
        productListViewModel.requestProductsViewMode()
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_button -> {
                productListViewModel.changeProductsViewMode()
            }
        }
        return true
    }

    private fun initToolbar() {
        toolbar.title = "FoodApp"
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        setHasOptionsMenu(true)
    }

    private fun changeMenuIcon(mode: TableMode) {
        val iconResId = when (mode) {
            TableMode.LIST -> R.drawable.ic_menu_grid
            TableMode.GRID -> R.drawable.ic_menu_list
        }
        val item = optionsMenu?.findItem(R.id.menu_button)
        item?.setIcon(iconResId)
    }

    private fun initRv() {
        Timber.tag(App.APP_LOG_TAG).i("$logTitle.initRv")
        adapter = FoodListRecyclerViewAdapter(mutableListOf()) { id ->
            toast("$id")
        }
        swipeRefreshLayout.isRefreshing = true
        productListViewModel.requestProducts()
        recyclerView.adapter = adapter
    }

    private fun setAdapterMode(mode: TableMode) {

        while (recyclerView.itemDecorationCount > 0) {
            recyclerView.removeItemDecorationAt(0)
        }

        if (mode == TableMode.GRID) {
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
            productListViewModel.requestProducts()
        }
    }

    companion object {
        fun newInstance() =
            MainTabFragment()
    }
}

/**
 * Класс для устновки одинаковых расстояний между ячейками сетки
 */
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