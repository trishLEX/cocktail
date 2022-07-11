package ru.trishlex.ingredient

import org.springframework.stereotype.Service
import ru.trishlex.ingredient.model.Ingredient
import ru.trishlex.ingredient.model.IngredientLight
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

    fun getIngredient(id: Int): Ingredient {
        return ingredientDao.getIngredient(id)
    }

    fun getIngredients(name: String, start: Int?, limit: Int?): List<IngredientLight> {
        return ingredientDao.getIngredients(name, start ?: START, limit ?: LIMIT)
    }

    fun getIngredients(ids: List<Int>): List<IngredientLight> {
        return ingredientDao.getIngredients(ids)
    }
}