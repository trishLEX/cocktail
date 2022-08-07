package ru.trishlex.tool.model

import org.openapitools.model.ToolLightDTO

data class ToolLight(
    val id: Int,
    val name: String,
    val preview: ByteArray
) {

    fun toDto(): ToolLightDTO {
        return ToolLightDTO(id, preview, name)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ToolLight

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }
}