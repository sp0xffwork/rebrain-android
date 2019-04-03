package com.pavel.rebrain.screen.main.carousel

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pavel.rebrain.R
import kotlinx.android.synthetic.main.fragment_carousel.*
import timber.log.Timber

private const val ARG_PARAM_PICTURE_NAME = "picture_name"

/**
 * CarouselFragment
 * [CarouselFragment.newInstance] factory method
 */
class CarouselFragment : Fragment() {
    private var pictureName: String? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Timber.tag("FoodApp").i("CarouselFragment.onAttach. picture=${pictureName}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pictureName = it.getString(ARG_PARAM_PICTURE_NAME)
        }
        Timber.tag("FoodApp").i("CarouselFragment.onCreate. picture=${pictureName}")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.tag("FoodApp").i("CarouselFragment.onCreateView. picture=${pictureName}")
        return inflater.inflate(R.layout.fragment_carousel, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        pictureName?.let {
            image.setImageDrawable(Drawable.createFromStream(activity!!.assets.open(it), null))
        }
        Timber.tag("FoodApp").i("CarouselFragment.onActivityCreated. picture=${pictureName}")
    }

    override fun onStart() {
        super.onStart()
        Timber.tag("FoodApp").i("CarouselFragment.onStart. picture=${pictureName}")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag("FoodApp").i("CarouselFragment.onResume. picture=${pictureName}")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag("FoodApp").i("CarouselFragment.onPause. picture=${pictureName}")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag("FoodApp").i("CarouselFragment.onStop. picture=${pictureName}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.tag("FoodApp").i("CarouselFragment.onDestroyView. picture=${pictureName}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag("FoodApp").i("CarouselFragment.onDestroy. picture=${pictureName}")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.tag("FoodApp").i("CarouselFragment.onDetach. picture=${pictureName}")
    }

    companion object {
        fun newInstance(pictureName: String?) =
            CarouselFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM_PICTURE_NAME, pictureName)
                }
            }
    }
}
