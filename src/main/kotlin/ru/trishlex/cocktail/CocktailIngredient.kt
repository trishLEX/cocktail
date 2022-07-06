package ru.trishlex.cocktail

data class CocktailIngredient(
    val ingredientId: Int,
    val preview: ByteArray,
    val amount: Int,
    val unit: String
)