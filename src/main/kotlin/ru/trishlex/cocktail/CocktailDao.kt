package ru.trishlex.cocktail

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import ru.trishlex.cocktail.model.CocktailIngredient
import ru.trishlex.cocktail.model.CocktailLight
import ru.trishlex.cocktail.model.CocktailName

@Repository
class CocktailDao(private val namedJdbcTemplate: NamedParameterJdbcTemplate) {

    companion object {
        private const val LIMIT = 10
        private const val GET_COCKTAIL_NAMES = "" +
                "select id, name\n" +
                "from cocktail\n" +
                "where lower(name) like lower(:name)\n" +
                "order by id\n" +
                "limit :limit\n"

        private const val GET_LIGHT_COCKTAILS = "" +
                "select\n" +
                "   c.id cid,\n" +
                "   c.name cname,\n" +
                "   c.preview cpreview,\n" +
                "   i.id iid,\n" +
                "   i.name iname,\n" +
                "   i.preview ipreview,\n" +
                "   ci.amount ciamount,\n" +
                "   ci.unit ciunit\n" +
                "from cocktail c\n" +
                "join cocktail_ingredients ci on c.id = ci.cocktail_id\n" +
                "join ingredient i on ci.ingredient_id = i.id\n" +
                "where c.id > :id and lower(c.name) like lower(:name)\n" +
                "order by c.id\n" +
                "limit :limit"
    }

    fun getCocktailNames(name: String): List<CocktailName> {
        return namedJdbcTemplate.query(
            GET_COCKTAIL_NAMES,
            MapSqlParameterSource()
                .addValue("name", "$name%")
                .addValue("limit", LIMIT)
        ) { rs, _ -> CocktailName(rs.getInt("id"), rs.getString("name")) }
    }

    fun getLightCocktails(name: String, start: Int, limit: Int): List<CocktailLight> {
        val cocktails = HashMap<Int, CocktailLight>()
        namedJdbcTemplate.query(
            GET_LIGHT_COCKTAILS,
            MapSqlParameterSource()
                .addValue("name", "$name%")
                .addValue("id", start)
                .addValue("limit", limit)
        ) { rs ->
            run {
                val cocktailId = rs.getInt("cid")
                val cocktailLight = cocktails.computeIfAbsent(
                    cocktailId
                ) { id ->
                    CocktailLight(
                        id,
                        rs.getString("cname"),
                        rs.getBytes("cpreview"),
                        ArrayList()
                    )
                }

                val cocktailIngredient = CocktailIngredient(
                    rs.getInt("iid"),
                    rs.getString("iname"),
                    rs.getBytes("ipreview"),
                    rs.getInt("ciamount"),
                    rs.getString("ciunit")
                )

                cocktailLight.ingredients.add(cocktailIngredient)
            }
        }
        return ArrayList(cocktails.values)
    }
}
