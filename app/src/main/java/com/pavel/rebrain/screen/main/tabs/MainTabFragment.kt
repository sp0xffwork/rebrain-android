package com.pavel.rebrain.screen.main.tabs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pavel.rebrain.R
import com.pavel.rebrain.domain.util.Generator
import com.pavel.rebrain.screen.base.BaseFragment
import com.pavel.rebrain.screen.main.OnFragmentInteractionListener
import com.pavel.rebrain.screen.main.list.FoodListRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_main_tab.*
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 * MainTabFragment
 * показывает карусель
 */
class MainTabFragment : BaseFragment("MainTabFragment") {

    private var listener: OnFragmentInteractionListener? = null
    private lateinit var adapter: FoodListRecyclerViewAdapter

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

        /*
        val arrayOfPictureResIds =
            arrayOf(
                R.drawable.pic_1,
                R.drawable.pic_2,
                R.drawable.pic_3,
                R.drawable.pic_4,
                R.drawable.pic_5,
                R.drawable.pic_6,
                R.drawable.pic_7,
                R.drawable.pic_8,
                R.drawable.pic_9,
                R.drawable.pic_10
            )
        */

        //val pagerAdapter = CarouselFragmentPagerAdapter(childFragmentManager, arrayOfPictureResIds)
        //val statePagerAdapter = CarouselFragmentStatePagerAdapter(childFragmentManager, arrayOfPictureResIds)
        //pager.adapter = pagerAdapter
        //pager.adapter = statePagerAdapter

        initToobar()
        initRv()
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

    private fun initToobar() {
        toolbar.title = "FoodApp"
        (activity as? AppCompatActivity)?.setSupportActionBar(toolbar)
    }

    private fun initRv() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = FoodListRecyclerViewAdapter(Generator().getProducts())
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    companion object {
        fun newInstance() =
            MainTabFragment()
    }
}
