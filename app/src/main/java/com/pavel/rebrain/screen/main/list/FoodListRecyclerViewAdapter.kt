package com.pavel.rebrain.screen.main.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.pavel.rebrain.App
import com.pavel.rebrain.R
import com.pavel.rebrain.domain.Product
import com.pavel.rebrain.screen.base.BaseActivity
import com.pavel.rebrain.screen.main.carousel.adapter.CarouselFragmentStatePagerAdapter
import kotlinx.android.synthetic.main.list_element_carousel.view.*
import kotlinx.android.synthetic.main.list_element_row.view.*
import timber.log.Timber


/**
 * Adapter для RecyclerView для отображения списка продуктов
 */
class FoodListRecyclerViewAdapter(private var foodList: MutableList<Product>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class TableMode {
        List, Grid
    }

    enum class ElementType(val type: Int) {
        Carousel(0), Normal(1)
    }

    private var isGrid: Boolean = false

    fun setTabledMode(mode: TableMode) {
        isGrid = mode == TableMode.Grid
        notifyDataSetChanged()
    }

    fun setFoodList(foodList: MutableList<Product>) {
        this.foodList = foodList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val holder = when (ElementType.values()[viewType]) {
            ElementType.Carousel -> {
                HolderCarousel(parent)
            }
            ElementType.Normal -> {
                val elementResId = if (isGrid) {
                    R.layout.grid_element_cell
                } else {
                    R.layout.list_element_row
                }
                val v = LayoutInflater.from(parent.context).inflate(elementResId, parent, false)
                HolderNormal(parent, v)
            }
        }

        Timber.tag(App.APP_LOG_TAG).i("onCreateViewHolder ${parent.context}")
        return holder
    }

    override fun getItemCount(): Int {
        // в grid нет карусели и количество элементов равно размеру списка
        return if (isGrid) foodList.size else foodList.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        // карусель только на первой позиции списка, но не в grid
        return if (position == 0 && !isGrid) ElementType.Carousel.type else ElementType.Normal.type
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Timber.tag(App.APP_LOG_TAG).i("onBindViewHolder $position")
        when (ElementType.values()[getItemViewType(position)]) {
            ElementType.Carousel -> {
                (holder as HolderCarousel).bind()
            }
            ElementType.Normal -> {
                // учитываем, что в списке добавлена карусель, как дополнитедльный элемент
                (holder as HolderNormal).bind(foodList[if (isGrid) position else position - 1])
            }
        }
    }

    /**
     * Holder для строк, связанных с продуктами
     */
    class HolderNormal(private val parent: ViewGroup, v: View) : RecyclerView.ViewHolder(v) {

        private var productNameView: TextView = v.textProductName
        private var productPriceView: TextView = v.textProductPrice
        private var productImageView: ImageView = v.imageProduct

        fun bind(data: Product) {
            productNameView.text = data.name
            @SuppressLint("SetTextI18n")
            productPriceView.text = "${data.id * 10}"

            Glide
                .with(parent.context)
                .load(
                    when (data.id % 4) {
                        0 -> R.drawable.pic_1
                        1 -> R.drawable.pic_2
                        2 -> R.drawable.pic_3
                        else -> R.drawable.pic_4
                    }
                )
                .placeholder(R.drawable.eda)
                .error(R.mipmap.ic_launcher)
                .centerCrop()
                .into(productImageView)
        }
    }

    /**
     * Holder для строк, связанных с встроенной каруселью
     */
    class HolderCarousel(v: View) : RecyclerView.ViewHolder(v) {
        private lateinit var context: Context
        private var carousel: ViewPager = v.elementCarouselPager
        private var dots: TabLayout = v.elementCarouselTabLayout

        constructor(parent: ViewGroup) : this(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_element_carousel, parent, false)
        ) {
            context = parent.context
        }

        fun bind() {
            // массив layout для показа в карусели
            val arrayOfPictureResIds =
                arrayOf(
                    R.drawable.element_carousel,
                    R.drawable.element_carousel,
                    R.drawable.element_carousel
                )

            // карусель нормально перерисовывается только, если FragmentStatePagerAdapter
            val pagerAdapter = CarouselFragmentStatePagerAdapter(
                (context as BaseActivity).supportFragmentManager,
                arrayOfPictureResIds
            )
            carousel.adapter = pagerAdapter
            dots.setupWithViewPager(carousel, true)
        }
    }
}
