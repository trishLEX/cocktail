package ru.trishlex.cocktail

data class Cocktail(
    val id: Int,
    val name: String,
    val image: ByteArray,
    val preview: ByteArray,
    val instructions: List<String>,
    val description: String?,
    val tags: List<String>
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
}