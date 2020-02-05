package com.pavel.rebrain.screen.main.list

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
    private var starClickListener: (id: Int) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var favoritesList: MutableList<Product>? = null

    fun setFoodList(foodList: MutableList<Product>) {
        this.favoritesList = foodList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_fav_element_row, parent, false)
        val holder = FavoriteElementHolder(parent, v, starClickListener)
        Timber.tag(App.APP_LOG_TAG).i("onCreateViewHolder ${parent.context}")
        return holder
    }

    override fun getItemCount(): Int {
        return favoritesList?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Timber.tag(App.APP_LOG_TAG).i("onBindViewHolder $position")
        favoritesList?.let {
            (holder as FavoriteElementHolder).bind(it[position])
        }
    }

    /**
     * Holder для строк, связанных с продуктами
     */
    class FavoriteElementHolder(
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
            productPriceView.text = data.price.toString()

            Glide
                .with(parent.context)
                .load(
                    when (data.pictureId) {
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
