package ru.trishlex.cocktail

import org.springframework.stereotype.Service
import ru.trishlex.cocktail.model.Cocktail
import ru.trishlex.cocktail.model.CocktailLight
import ru.trishlex.cocktail.model.CocktailName

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

    fun getCocktail(id: Int): Cocktail {
        return cocktailDao.getCocktail(id)
    }
}