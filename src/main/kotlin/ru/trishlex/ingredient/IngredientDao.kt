package ru.trishlex.ingredient

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import ru.trishlex.ingredient.model.Ingredient
import ru.trishlex.ingredient.model.IngredientLight
import ru.trishlex.ingredient.model.IngredientName

@Repository
class IngredientDao(private val namedJdbcTemplate: NamedParameterJdbcTemplate) {

    companion object {
        private const val LIMIT = 10
        private const val GET_INGREDIENT_NAMES = "" +
                "select id, name\n" +
                "from ingredient\n" +
                "where lower(name) like lower(:name)\n" +
                "order by id\n" +
                "limit :limit\n"

        private const val GET_INGREDIENTS = "" +
                "select\n" +
                "   id,\n" +
                "   name,\n" +
                "   preview\n" +
                "from ingredient\n" +
                "where id > :id and lower(name) like lower(:name)\n" +
                "order by id\n" +
                "limit :limit"

        private const val GET_INGREDIENT = "" +
                "select\n" +
                "   id,\n" +
                "   name,\n" +
                "   image,\n" +
                "   description,\n" +
                "   tags\n" +
                "from ingredient\n" +
                "where id = :id"

        private const val GET_INGREDIENTS_BY_ID = "" +
                "select\n" +
                "   id,\n" +
                "   name,\n" +
                "   preview\n" +
                "from ingredient\n" +
                "where id in (:ids)\n" +
                "order by id"
    }

    fun getIngredientNames(name: String): List<IngredientName> {
        return namedJdbcTemplate.query(
            GET_INGREDIENT_NAMES,
            MapSqlParameterSource()
                .addValue("name", "%$name%")
                .addValue("limit", LIMIT)
        ) { rs, _ -> IngredientName(rs.getInt("id"), rs.getString("name")) }
    }

    fun getIngredients(name: String, start: Int, limit: Int): List<IngredientLight> {
        return namedJdbcTemplate.query(
            GET_INGREDIENTS,
            MapSqlParameterSource()
                .addValue("id", start)
                .addValue("name", "%$name%")
                .addValue("limit", limit)
        ) { rs, _ -> IngredientLight(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getBytes("preview")
        )}
    }

    fun getIngredients(ids: List<Int>): List<IngredientLight> {
        return namedJdbcTemplate.query(
            GET_INGREDIENTS_BY_ID,
            MapSqlParameterSource("ids", ids)
        ) { rs, _ -> IngredientLight(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getBytes("preview")
        )}
    }

    fun getIngredient(id: Int): Ingredient {
        return namedJdbcTemplate.queryForObject(
            GET_INGREDIENT,
            MapSqlParameterSource("id", id)
        ) {rs, _ -> Ingredient(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getBytes("image"),
            rs.getString("description"),
            ((rs.getArray("tags").array) as Array<String>).toList()
        )}!!
    }
}