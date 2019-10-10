package com.pavel.rebrain.screen.main.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.pavel.rebrain.screen.base.BaseFragment

private const val ARG_PARAM_LAYOUT_RES_ID = "layout_res_id"

/**
 * ElementCarouselFragment
 * Фрагмент для отображения элемента карусели
 * [ElementCarouselFragment.newInstance] factory method
 */
class ElementCarouselFragment : BaseFragment("ElementCarouselFragment") {
    private var layoutResId: Int = 0

    override fun getFragmentTag(): String {
        return "ElementCarouselFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            layoutResId = it.getInt(ARG_PARAM_LAYOUT_RES_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(layoutResId, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        fun newInstance(layoutResId: Int) =
            ElementCarouselFragment().apply {
                arguments = bundleOf(ARG_PARAM_LAYOUT_RES_ID to layoutResId)
            }
    }
}
