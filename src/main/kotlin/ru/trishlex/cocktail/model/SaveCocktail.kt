package ru.trishlex.cocktail.model

import org.openapitools.model.SaveCocktailRequestDTO

data class SaveCocktail(
    val name: String,
    val preview: ByteArray,
    val image: ByteArray,
    val ingredients: List<SaveIngredient> = ArrayList(),
    val toolIds: List<Int> = ArrayList(),
    val instructions: List<String> = ArrayList(),
    val description: String?,
    val tags: List<String> = ArrayList()
) {

    constructor(saveCocktailRequestDTO: SaveCocktailRequestDTO): this(
        saveCocktailRequestDTO.name!!,
        saveCocktailRequestDTO.preview!!,
        saveCocktailRequestDTO.image!!,
        saveCocktailRequestDTO.ingredients!!.map { SaveIngredient(it) },
        saveCocktailRequestDTO.tools!!,
        saveCocktailRequestDTO.instructions!!,
        saveCocktailRequestDTO.description,
        saveCocktailRequestDTO.tags ?: emptyList()
    )
}