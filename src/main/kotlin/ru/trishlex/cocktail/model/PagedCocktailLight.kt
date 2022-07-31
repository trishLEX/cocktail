package ru.trishlex.cocktail.model

import org.openapitools.model.CocktailLightDTO

data class PagedCocktailLight(
    val id: Int,
    val name: String,
    val preview: ByteArray,
    val missingIngredientsCount: Int,
    val ingredients: ArrayList<CocktailIngredient> = ArrayList()
) {
    fun toDto(): CocktailLightDTO {
        return CocktailLightDTO(id, name, preview, missingIngredientsCount, ingredients.map { it.toDto() })
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CocktailLight

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }
}