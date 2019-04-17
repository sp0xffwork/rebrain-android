package com.pavel.rebrain.screen.main.tabs

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pavel.rebrain.R
import com.pavel.rebrain.screen.base.BaseFragment
import com.pavel.rebrain.screen.main.carousel.adapter.CarouselFragmentPagerAdapter
import com.pavel.rebrain.screen.main.carousel.adapter.CarouselFragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main_tab.*

/**
 * MainTabFragment
 * показывает карусель
 */
class MainTabFragment : BaseFragment() {
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        val pagerAdapter = CarouselFragmentPagerAdapter(childFragmentManager, arrayOfPictureResIds)
        val statePagerAdapter = CarouselFragmentStatePagerAdapter(childFragmentManager, arrayOfPictureResIds)

        pager.adapter = pagerAdapter
        //pager.adapter = statePagerAdapter
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

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        fun newInstance() =
            MainTabFragment()
    }
}
