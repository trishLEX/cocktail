package ru.trishlex.cocktail.model

import org.openapitools.model.CocktailDTO

data class Cocktail(
    val id: Int,
    val name: String,
    val image: ByteArray,
    val ingredients: ArrayList<CocktailIngredient> = ArrayList(),
    val tools: ArrayList<CocktailTool> = ArrayList(),
    val toolIds: List<Int> = ArrayList(),
    val instructions: List<String> = ArrayList(),
    val description: String,
    val tags: List<String> = ArrayList()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cocktail

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }

    fun toDto(): CocktailDTO {
        return CocktailDTO(
            id,
            name,
            image,
            ingredients.map { it.toDto() },
            tools.map { it.toDto() },
            instructions,
            description,
            tags
        )
    }
}