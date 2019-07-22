package com.pavel.rebrain.screen.main.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pavel.rebrain.R
import com.pavel.rebrain.domain.Product
import kotlinx.android.synthetic.main.element.view.*

/**
 * Adapter для RecyclerView для отображения списка продуктов
 */
class FoodListRecyclerViewAdapter(private var foodList: MutableList<Product>) :
    RecyclerView.Adapter<FoodListRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(parent, LayoutInflater.from(parent.context).inflate(R.layout.element, parent, false))
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
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
                .with(productImageView.context)
                .load(R.drawable.pic_1)
                .centerCrop()
                .into(productImageView);
        }
    }
}
