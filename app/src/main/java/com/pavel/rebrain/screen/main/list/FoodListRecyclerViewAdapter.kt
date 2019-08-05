package com.pavel.rebrain.screen.main.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pavel.rebrain.App
import com.pavel.rebrain.R
import com.pavel.rebrain.domain.Product
import kotlinx.android.synthetic.main.element_list.view.*
import timber.log.Timber

/**
 * Adapter для RecyclerView для отображения списка продуктов
 */
class FoodListRecyclerViewAdapter(private var foodList: MutableList<Product>) :
    RecyclerView.Adapter<FoodListRecyclerViewAdapter.Holder>() {

    enum class TableMode {
        List, Grid
    }

    private var grid: Boolean = false

    fun setTabledMode(mode: TableMode) {
        grid = mode == TableMode.Grid
        notifyDataSetChanged()
    }

    fun setFoodList(foodList: MutableList<Product>) {
        this.foodList = foodList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val elementResId = if (grid) {
            R.layout.element_grid
        } else {
            R.layout.element_list
        }
        val v = LayoutInflater.from(parent.context).inflate(elementResId, parent, false)
        val holder = Holder(parent, v)
        Timber.tag(App.APP_LOG_TAG).i("onCreateViewHolder ${parent.context}")
        return holder
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Timber.tag(App.APP_LOG_TAG).i("onBindViewHolder $position")
        val product = foodList[position]
        holder.bind(product)
    }

    class Holder(private val parent: ViewGroup, v: View) : RecyclerView.ViewHolder(v) {

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
}
