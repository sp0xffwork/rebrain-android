package com.pavel.rebrain.screen.main.carousel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.pavel.rebrain.R
import com.pavel.rebrain.screen.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_carousel.*

private const val ARG_PARAM_PICTURE_RES_ID = "picture_res_id"

/**
 * CarouselFragment
 * [CarouselFragment.newInstance] factory method
 */
class CarouselFragment : BaseFragment("CarouselFragment") {
    private var pictureResId: Int = 0

    override fun getFragmentTag() : String {
        return "CarouselFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pictureResId = it.getInt(ARG_PARAM_PICTURE_RES_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_carousel, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (pictureResId > 0) {
            image.setImageResource(pictureResId)
        }
    }

    companion object {
        fun newInstance(pictureResId: Int) =
            CarouselFragment().apply {
                arguments = bundleOf(ARG_PARAM_PICTURE_RES_ID to pictureResId)
            }
    }
}
