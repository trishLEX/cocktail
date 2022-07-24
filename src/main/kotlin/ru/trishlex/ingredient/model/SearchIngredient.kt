package ru.trishlex.ingredient.model

import org.openapitools.model.SearchIngredientDTO

data class SearchIngredient(val ingredientId: Int, val name: String, val ingredientType: IngredientType) {

    fun toDto(): SearchIngredientDTO {
        return SearchIngredientDTO(ingredientId, name, ingredientType.toDto())
    }
}
