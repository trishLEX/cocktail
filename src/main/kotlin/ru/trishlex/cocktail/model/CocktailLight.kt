package ru.trishlex.cocktail.model

import org.openapitools.model.CocktailLightDTO

data class CocktailLight(
    val id: Int,
    val name: String,
    val preview: ByteArray,
    val ingredients: ArrayList<CocktailIngredient> = ArrayList()
) {

    fun toDto(): CocktailLightDTO {
        return CocktailLightDTO(id = id, name = name, preview = preview, ingredients = ingredients.map { it.toDto() })
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