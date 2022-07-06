package ru.trishlex.cocktail

import org.springframework.stereotype.Service

@Service
class CocktailService(private val cocktailDao: CocktailDao) {

    fun getCocktailNames(name: String): List<String> {
        return cocktailDao.getCocktailNames(name)
    }
}