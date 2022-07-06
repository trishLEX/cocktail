package ru.trishlex.ingredient.model

import org.openapitools.model.IngredientNameDTO

data class IngredientName(
    val id: Int,
    val name: String
) {

    fun toDto(): IngredientNameDTO {
        return IngredientNameDTO(id, name)
    }
}