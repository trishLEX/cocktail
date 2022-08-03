package ru.trishlex.ingredient.model

import org.openapitools.model.IngredientDTO

data class Ingredient(
    val id: Int,
    val name: String,
    val image: ByteArray,
    val type: IngredientType,
    val description: String,
    val tags: List<String>
) {

    fun toDto(): IngredientDTO {
        return IngredientDTO(id, name, image, type.toDto(), description, tags)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Ingredient

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }
}