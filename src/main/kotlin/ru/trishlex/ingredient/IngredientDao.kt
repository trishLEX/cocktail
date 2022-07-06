package ru.trishlex.ingredient

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
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
    }

    fun getIngredientNames(name: String): List<IngredientName> {
        return namedJdbcTemplate.query(
            GET_INGREDIENT_NAMES,
            MapSqlParameterSource()
                .addValue("name", "$name%")
                .addValue("limit", LIMIT)
        ) { rs, _ -> IngredientName(rs.getInt("id"), rs.getString("name")) }
    }
}