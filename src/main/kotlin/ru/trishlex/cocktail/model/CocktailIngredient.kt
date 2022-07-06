package ru.trishlex.cocktail.model

import org.openapitools.model.CocktailIngredientDTO

data class CocktailIngredient(
    val ingredientId: Int,
    val name: String,
    val preview: ByteArray,
    val amount: Int,
    val unit: String
) {

    fun toDto(): CocktailIngredientDTO {
        return CocktailIngredientDTO(ingredientId, name, preview, amount, unit)
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CocktailIngredient

        if (ingredientId != other.ingredientId) return false

        return true
    }

    override fun hashCode(): Int {
        return ingredientId
    }
}