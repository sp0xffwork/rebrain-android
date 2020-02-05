package com.pavel.rebrain.domain.util

import com.pavel.rebrain.domain.Product

class Generator {
    private fun getOriginalProductsList(): MutableList<Product> {
        return mutableListOf(
            Product(0, "Салат из морских водрослей с ореховым соусом", 100,0),
            Product(1, "Спайси лосось с жасминовым рисом", 110, 1),
            Product(2, "Рисовая лапша с морепродуктами", 120, 2),
            Product(3, "Фирменная закуска баклажан", 130,3),
            Product(4, "Шашлык из свиной шеи\n", 140, 0),
            Product(5, "Пита с куриной котлетой и омлетом", 150, 1),
            Product(6, "Соба с курицей в остро-сладком соусе", 160, 2),
            Product(7, "Удон с курицей в остро-сладком соусе", 170, 3),
            Product(8, "Суси с лососем", 180, 0),
            Product(9, "Гункан с лососем (острый)", 190, 1),
            Product(10, "Мисо-сяке", 200, 2),
            Product(11, "Салат греческий", 210, 3),
            Product(12, "Тяхан с овощами", 220, 0),
            Product(13, "Феттуччини с угрём", 230, 1),
            Product(14, "Чесночные гренки", 240, 2),
            Product(15, "Мидии в остром соусе", 250, 3),
            Product(16, "Маффин шоколадный", 260, 0),
            Product(17, "Чизкейк Нью-Йорк (вишня)", 270, 1),
            Product(18, "Морс (облепиха)", 280,2),
            Product(19, "Сок 1 л", 290,3)
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
        return  resultProductsList
    }
}