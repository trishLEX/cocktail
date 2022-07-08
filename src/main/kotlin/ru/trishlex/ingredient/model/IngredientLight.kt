package ru.trishlex.ingredient.model

import org.openapitools.model.IngredientLightDTO

data class IngredientLight(
    val id: Int,
    val name: String,
    val preview: ByteArray
) {

    fun toDto(): IngredientLightDTO {
        return IngredientLightDTO(id, preview, name)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as IngredientLight

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }
}