package ru.trishlex.cocktail.model

import org.openapitools.model.CocktailNameDTO

data class CocktailName(
    val id: Int,
    val name: String
) {

    fun toDTO(): CocktailNameDTO {
        return CocktailNameDTO(id, name)
    }
}