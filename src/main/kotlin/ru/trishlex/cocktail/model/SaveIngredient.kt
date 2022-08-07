package ru.trishlex.cocktail.model

import org.openapitools.model.SaveIngredientRequestDTO

data class SaveIngredient (
    val id: Int,
    val amount: Int,
    val unit: String
) {

    constructor(saveIngredientRequestDTO: SaveIngredientRequestDTO) : this(
        saveIngredientRequestDTO.id!!,
        saveIngredientRequestDTO.amount!!,
        saveIngredientRequestDTO.unit!!
    )
}