package ru.trishlex.cocktail.model

import org.openapitools.model.PagedCocktailLightResponse

data class CocktailPage(val hasNext: Boolean, val nextStart: Int, val cocktails: List<PagedCocktailLight>) {

    fun toDto(): PagedCocktailLightResponse {
        return PagedCocktailLightResponse(hasNext, nextStart, cocktails.map { it.toDto() })
    }
}
