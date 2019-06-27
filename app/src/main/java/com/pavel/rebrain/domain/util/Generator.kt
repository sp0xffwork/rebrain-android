package com.pavel.rebrain.domain.util

import com.pavel.rebrain.domain.Product

class Generator {
    private fun getOriginalProductsList(): List<Product> {
        return listOf(
            Product(0, "Салат из морских водрослей с ореховым соусом"),
            Product(1, "Спайси лосось с жасминовым рисом"),
            Product(2, "Рисовая лапша с морепродуктами"),
            Product(3, "Фирменная закуска баклажан"),
            Product(4, "Шашлык из свиной шеи\n"),
            Product(5, "Пита с куриной котлетой и омлетом"),
            Product(6, "Соба с курицей в остро-сладком соусе"),
            Product(7, "Удон с курицей в остро-сладком соусе"),
            Product(8, "Суси с лососем"),
            Product(9, "Гункан с лососем (острый)"),
            Product(10, "Мисо-сяке"),
            Product(11, "Салат греческий"),
            Product(12, "Тяхан с овощами"),
            Product(13, "Феттуччини с угрём"),
            Product(14, "Чесночные гренки"),
            Product(15, "Мидии в остром соусе"),
            Product(16, "Маффин шоколадный"),
            Product(17, "Чизкейк Нью-Йорк (вишня)"),
            Product(18, "Морс (облепиха)"),
            Product(19, "Сок 1 л")
        )
    }

    fun getProducts(): List<Product> {
        val originalProductsList = getOriginalProductsList() as MutableList<Product>
        val resultProductsList = mutableListOf<Product>()
        for (i in 19 downTo 0) {
            val rnd = (0..i).random()
            val product = originalProductsList.removeAt(rnd)
            resultProductsList.add(product)
        }
        return  resultProductsList
    }
}