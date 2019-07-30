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
import kotlinx.android.synthetic.main.element.view.*
import timber.log.Timber

/**
 * Adapter для RecyclerView для отображения списка продуктов
 */
class FoodListRecyclerViewAdapter(private var foodList: MutableList<Product>) :
    RecyclerView.Adapter<FoodListRecyclerViewAdapter.Holder>() {

    fun setFoodList(foodList: MutableList<Product>) {
        this.foodList = foodList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val holder = Holder(parent, LayoutInflater.from(parent.context).inflate(R.layout.element, parent, false))
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
            productPriceView.text = "${data.id * 10} руб"

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
                //.skipMemoryCache(true)
                //.diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.eda)
                .error(R.mipmap.ic_launcher)
                .centerCrop()
                .into(productImageView)
        }
    }
}
