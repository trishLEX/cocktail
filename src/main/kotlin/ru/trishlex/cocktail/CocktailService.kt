package ru.trishlex.cocktail

import org.springframework.stereotype.Service
import ru.trishlex.cocktail.model.Cocktail
import ru.trishlex.cocktail.model.CocktailLight
import ru.trishlex.cocktail.model.CocktailName
import ru.trishlex.cocktail.model.CocktailPage

@Service
class CocktailService(private val cocktailDao: CocktailDao) {

    companion object {
        private const val START = 0
        private const val LIMIT = 50
    }

    fun getCocktailNames(name: String): List<CocktailName> {
        return cocktailDao.getCocktailNames(name)
    }

    fun getLightCocktails(name: String, start: Int?, limit: Int?): List<CocktailLight> {
        return cocktailDao.getLightCocktails(name, start ?: START, limit ?: LIMIT).sortedBy { it.id }
    }

    fun getLightCocktails(ingredientId: Int, start: Int?, limit: Int?): List<CocktailLight> {
        return cocktailDao.getCocktailsByIngredient(ingredientId, start ?: START, limit ?: LIMIT).sortedBy { it.id }
    }

    fun getLightCocktails(ingredientIds: HashSet<Int>, start: Int?, limit: Int?): List<CocktailLight> {
        return cocktailDao.getCocktailsByIngredientIds(ingredientIds, start ?: START, limit ?: LIMIT).sortedBy { it.id }
    }

    fun getAllLightCocktails(
        ingredientIds: HashSet<Int>,
        start: Int?,
        limit: Int?
    ): CocktailPage {
        val definedStart = start ?: START
        val definedLimit = limit ?: LIMIT
        val cocktails = cocktailDao.getAllCocktailsByIngredientIds(
            ingredientIds,
            definedStart,
            definedLimit
        )
        return CocktailPage(
            cocktails.size >= definedLimit,
            definedStart + definedLimit,
            cocktails
        )
    }

    fun getLightCocktails(ids: List<Int>, start: Int?, limit: Int?): List<CocktailLight> {
        return cocktailDao.getCocktailsByIds(ids, start ?: START, limit ?: LIMIT).sortedBy { it.id }
    }

    fun getCocktail(id: Int): Cocktail {
        return cocktailDao.getCocktail(id)
    }
}