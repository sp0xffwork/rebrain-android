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
import kotlinx.android.synthetic.main.list_fav_element_row.view.*
import timber.log.Timber


/**
 * Adapter для RecyclerView для отображения списка избранных продуктов
 */
class FavoritesRecyclerViewAdapter(
    private var favoritesList: MutableList<Product>,
    private var starClickListener: (id: Int) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setFoodList(foodList: MutableList<Product>) {
        this.favoritesList = foodList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_fav_element_row, parent, false)
        val holder = NormalHolder(parent, v, starClickListener)
        Timber.tag(App.APP_LOG_TAG).i("onCreateViewHolder ${parent.context}")
        return holder
    }

    override fun getItemCount(): Int {
        return favoritesList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Timber.tag(App.APP_LOG_TAG).i("onBindViewHolder $position")
        (holder as NormalHolder).bind(favoritesList[position])
    }

    /**
     * Holder для строк, связанных с продуктами
     */
    class NormalHolder(
        private val parent: ViewGroup,
        v: View,
        private val cartClickListener: (id: Int) -> Unit
    ) : RecyclerView.ViewHolder(v) {

        private var productId: Int = -1
        private var productNameView: TextView = v.textProductName
        private var productPriceView: TextView = v.textProductPrice
        private var productImageView: ImageView = v.imageProduct
        private var starLayoutButton: View = v.layoutStar

        init {
            starLayoutButton.setOnClickListener {
                cartClickListener(productId)
            }
        }

        fun bind(data: Product) {
            productId = data.id
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
