package com.pavel.rebrain.repository

import com.pavel.rebrain.domain.Product
import com.pavel.rebrain.domain.util.Generator
import com.pavel.rebrain.screen.main.list.FoodListRecyclerViewAdapter

/**
 * класс логики формирования и хранения данных
 */
class ProductsRepository {
    var mode: FoodListRecyclerViewAdapter.TableMode = FoodListRecyclerViewAdapter.TableMode.LIST

    fun getProducts(): MutableList<Product> {
        return Generator().getProducts()
    }

    fun getProductsViewMode(): FoodListRecyclerViewAdapter.TableMode {
        return mode
    }

    fun changeProductsViewMode(): FoodListRecyclerViewAdapter.TableMode {
        mode = if (mode == FoodListRecyclerViewAdapter.TableMode.GRID) {
            FoodListRecyclerViewAdapter.TableMode.LIST
        } else {
            FoodListRecyclerViewAdapter.TableMode.GRID
        }
        return mode
    }



}