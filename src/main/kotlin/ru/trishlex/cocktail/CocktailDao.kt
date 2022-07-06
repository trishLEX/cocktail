package ru.trishlex.cocktail

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class CocktailDao(private val namedJdbcTemplate: NamedParameterJdbcTemplate) {

    companion object {
        private const val LIMIT = 10
        private const val GET_COCKTAIL_NAMES = "" +
                "select name\n" +
                "from cocktail\n" +
                "where lower(name) like lower(:name) limit :limit"
    }

    fun getCocktailNames(name: String): List<String> {
        return namedJdbcTemplate.queryForList(
            GET_COCKTAIL_NAMES,
            MapSqlParameterSource()
                .addValue("name", "$name%")
                .addValue("limit", LIMIT),
            String::class.java
        )
    }
}