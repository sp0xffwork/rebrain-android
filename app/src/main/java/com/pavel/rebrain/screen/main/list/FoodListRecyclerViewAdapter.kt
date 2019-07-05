package com.pavel.rebrain.screen.main.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pavel.rebrain.R
import com.pavel.rebrain.domain.Product
import kotlinx.android.synthetic.main.element.view.*

/**
 * Adapter для RecyclerView для отображения списка продуктов
 */
class FoodListRecyclerViewAdapter(
    private val context: Context, private var foodList: MutableList<Product>
) :
    RecyclerView.Adapter<FoodListRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(context).inflate(R.layout.element, parent, false))
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val product = foodList[position]
        holder.bind(product)
    }

    class Holder(v: View) : RecyclerView.ViewHolder(v) {
        var productNameView: TextView = v.textProductName
        var productPriceView: TextView = v.textProductPrice
        fun bind(data: Product) {
            productNameView.text = data.name
            productPriceView.text = "450 руб"
        }
    }
}
