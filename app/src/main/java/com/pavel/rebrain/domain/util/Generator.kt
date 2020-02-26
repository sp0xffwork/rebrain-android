package com.pavel.rebrain.domain.util

import com.pavel.rebrain.domain.Product

class Generator {
    private fun getOriginalProductsList(): MutableList<Product> {
        return mutableListOf(
            Product(0, "Салат из морских водрослей с ореховым соусом", 100, "", false),
            Product(1, "Спайси лосось с жасминовым рисом", 110, "", false),
            Product(2, "Рисовая лапша с морепродуктами", 120, "", false),
            Product(3, "Фирменная закуска баклажан", 130, "", false),
            Product(4, "Шашлык из свиной шеи\n", 140, "", false),
            Product(5, "Пита с куриной котлетой и омлетом", 150, "", false),
            Product(6, "Соба с курицей в остро-сладком соусе", 160, "", false),
            Product(7, "Удон с курицей в остро-сладком соусе", 170, "", false),
            Product(8, "Суси с лососем", 180, "", false),
            Product(9, "Гункан с лососем (острый)", 190, "", false),
            Product(10, "Мисо-сяке", 200, "", false),
            Product(11, "Салат греческий", 210, "", false),
            Product(12, "Тяхан с овощами", 220, "", false),
            Product(13, "Феттуччини с угрём", 230, "", false),
            Product(14, "Чесночные гренки", 240, "", false),
            Product(15, "Мидии в остром соусе", 250, "", false),
            Product(16, "Маффин шоколадный", 260, "", false),
            Product(17, "Чизкейк Нью-Йорк (вишня)", 270, "", false),
            Product(18, "Морс (облепиха)", 280, "", false),
            Product(19, "Сок 1 л", 290, "", false)
        )
    }

    fun getProducts(): MutableList<Product> {
        val originalProductsList = getOriginalProductsList()
        val resultProductsList = mutableListOf<Product>()
        for (i in 19 downTo 0) {
            val rnd = (0..i).random()
            val product = originalProductsList.removeAt(rnd)
            resultProductsList.add(product)
        }
        return resultProductsList
    }
}