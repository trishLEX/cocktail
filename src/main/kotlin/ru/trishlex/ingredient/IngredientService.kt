package ru.trishlex.ingredient

import org.springframework.stereotype.Service
import ru.trishlex.ingredient.model.IngredientName

@Service
class IngredientService(private val ingredientDao: IngredientDao) {

    companion object {
        private const val START = 0
        private const val LIMIT = 50
    }

    fun getIngredientNames(name: String): List<IngredientName> {
        return ingredientDao.getIngredientNames(name)
    }
}