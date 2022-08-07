package ru.trishlex.cocktail

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import ru.trishlex.cocktail.model.SaveIngredient

@Repository
class CocktailIngredientsDao(private val namedJdbcTemplate: NamedParameterJdbcTemplate) {

    companion object {
        private const val SAVE_INGREDIENTS = """
            insert into cocktail_ingredients (
                cocktail_id,
                ingredient_id,
                amount,
                unit
            ) values (
                :cocktailId,
                :ingredientId,
                :amount,
                :unit
            )
        """
    }

    fun saveCocktailIngredients(cocktailId: Int, saveIngredients: List<SaveIngredient>) {
        namedJdbcTemplate.batchUpdate(
            SAVE_INGREDIENTS,
            saveIngredients.map {
                MapSqlParameterSource()
                    .addValue("cocktailId", cocktailId)
                    .addValue("ingredientId", it.id)
                    .addValue("amount", it.amount)
                    .addValue("unit", it.unit)
            }.toTypedArray()
        )
    }
}