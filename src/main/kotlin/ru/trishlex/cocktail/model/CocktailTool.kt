package ru.trishlex.cocktail.model

import org.openapitools.model.CocktailToolDTO

data class CocktailTool(
    val id: Int,
    val name: String,
    val preview: ByteArray
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CocktailTool

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }

    fun toDto(): CocktailToolDTO {
        return CocktailToolDTO(id, name, preview)
    }
}