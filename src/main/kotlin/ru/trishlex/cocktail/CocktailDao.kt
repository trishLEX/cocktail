package ru.trishlex.cocktail

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository
import ru.trishlex.cocktail.model.*
import ru.trishlex.ingredient.model.IngredientType
import ru.trishlex.util.ArraySql
import ru.trishlex.util.injectedLogger
import java.sql.JDBCType

@Repository
class CocktailDao(private val namedJdbcTemplate: NamedParameterJdbcTemplate) {

    private val log by injectedLogger()
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
                "    c.id cid,\n" +
                "    c.name cname,\n" +
                "    c.preview cpreview,\n" +
                "    i.id iid,\n" +
                "    i.name iname,\n" +
                "    i.preview ipreview,\n" +
                "    i.type itype,\n" +
                "    ci.amount ciamount,\n" +
                "    ci.unit ciunit\n" +
                "from cocktail c\n" +
                "join cocktail_ingredients ci on c.id = ci.cocktail_id\n" +
                "join ingredient i on ci.ingredient_id = i.id\n" +
                "where c.id in (\n" +
                "    select id from cocktail\n" +
                "    where id > :id and lower(name) like lower(:name)\n" +
                "    order by id\n" +
                "    limit :limit\n" +
                ")\n" +
                "order by c.id"

        private const val GET_LIGHT_COCKTAILS_BY_INGREDIENT_ID = "" +
                "select\n" +
                "   c.id cid,\n" +
                "   c.name cname,\n" +
                "   c.preview cpreview,\n" +
                "   c.is_custom ciscustom,\n" +
                "   i.id iid,\n" +
                "   i.name iname,\n" +
                "   i.preview ipreview,\n" +
                "   i.type itype,\n" +
                "   ci.amount ciamount,\n" +
                "   ci.unit ciunit\n" +
                "from cocktail c\n" +
                "join cocktail_ingredients ci on c.id = ci.cocktail_id\n" +
                "join ingredient i on ci.ingredient_id = i.id\n" +
                "where c.id in (\n" +
                "   select id from cocktail\n" +
                "   where id > :id and :ingredientId = any(ingredients)" +
                "    order by id\n" +
                "    limit :limit\n" +
                ")"

        private const val GET_LIGHT_COCKTAILS_BY_INGREDIENT_IDS = "" +
                "select\n" +
                "   c.id cid,\n" +
                "   c.name cname,\n" +
                "   c.preview cpreview,\n" +
                "   c.is_custom ciscustom,\n" +
                "   i.id iid,\n" +
                "   i.name iname,\n" +
                "   i.preview ipreview,\n" +
                "   i.type itype,\n" +
                "   ci.amount ciamount,\n" +
                "   ci.unit ciunit\n" +
                "from cocktail c\n" +
                "join cocktail_ingredients ci on c.id = ci.cocktail_id\n" +
                "join ingredient i on ci.ingredient_id = i.id\n" +
                "where c.id in (\n" +
                "   select id from cocktail\n" +
                "   where id > :id and ingredients <@ :ingredientIds" +
                "    order by id\n" +
                "    limit :limit\n" +
                ")"

        private const val GET_ALL_LIGHT_COCKTAILS_BY_INGREDIENT_IDS = "" +
                "select\n" +
                "    c.id cid,\n" +
                "    c.name cname,\n" +
                "    c.preview cpreview,\n" +
                "    i.id iid,\n" +
                "    i.name iname,\n" +
                "    i.preview ipreview,\n" +
                "    i.type itype,\n" +
                "    ci.amount ciamount,\n" +
                "    ci.unit ciunit,\n" +
                "    cardinality(c.ingredients - :ingredientIds) missing_count\n" +
                "from cocktail c\n" +
                "join cocktail_ingredients ci on c.id = ci.cocktail_id\n" +
                "join ingredient i on ci.ingredient_id = i.id\n" +
                "where c.id in (\n" +
                "    select id from (\n" +
                "        select id, row_number() over (order by cardinality(ingredients - :ingredientIds)) rn\n" +
                "        from cocktail\n" +
                "        where ingredients && :ingredientIds\n" +
                "    ) c\n" +
                "    where rn > :start\n" +
                "    order by rn\n" +
                "    limit :limit\n" +
                ")"

        private const val GET_COCKTAIL = "" +
                "select\n" +
                "   c.id cid,\n" +
                "   c.name cname,\n" +
                "   c.image cimage,\n" +
                "   c.instructions cinstructions,\n" +
                "   c.description cdescription,\n" +
                "   c.tags ctags,\n" +
                "   c.tools ctools,\n" +
                "   c.is_custom ciscustom,\n" +
                "   i.id iid,\n" +
                "   i.name iname,\n" +
                "   i.preview ipreview,\n" +
                "   i.type itype,\n" +
                "   ci.amount ciamount,\n" +
                "   ci.unit ciunit\n" +
                "from cocktail c\n" +
                "join cocktail_ingredients ci on c.id = ci.cocktail_id\n" +
                "join ingredient i on ci.ingredient_id = i.id\n" +
                "where c.id = :id"

        private const val GET_TOOLS = "" +
                "select\n" +
                "   id,\n" +
                "   name,\n" +
                "   preview,\n" +
                "   description\n" +
                "from tool\n" +
                "where id in (:ids)"

        private const val GET_LIGHT_COCKTAILS_BY_IDS = "" +
                "select\n" +
                "    c.id cid,\n" +
                "    c.name cname,\n" +
                "    c.preview cpreview,\n" +
                "    c.is_custom ciscustom,\n" +
                "    i.id iid,\n" +
                "    i.name iname,\n" +
                "    i.preview ipreview,\n" +
                "    i.type itype,\n" +
                "    ci.amount ciamount,\n" +
                "    ci.unit ciunit\n" +
                "from cocktail c\n" +
                "join cocktail_ingredients ci on c.id = ci.cocktail_id\n" +
                "join ingredient i on ci.ingredient_id = i.id\n" +
                "where c.id in (\n" +
                "    select id from cocktail\n" +
                "    where id > :id and id in (:ids)\n" +
                "    order by id\n" +
                "    limit :limit\n" +
                ")"

        private const val SAVE_COCKTAIL = "" +
                "insert into cocktail (\n" +
                "   name,\n" +
                "   image,\n" +
                "   preview,\n" +
                "   ingredients,\n" +
                "   tools,\n" +
                "   instructions,\n" +
                "   description,\n" +
                "   tags,\n" +
                "   is_custom\n" +
                ") values (\n" +
                "   :name,\n" +
                "   :image,\n" +
                "   :preview,\n" +
                "   :ingredients,\n" +
                "   :tools,\n" +
                "   :instructions,\n" +
                "   :description,\n" +
                "   :tags,\n" +
                "   true\n" +
                ")"

        private const val UPDATE_COCKTAIL = """
            update cocktail
            set
                name = :name,
                image = :image,
                preview = :preview,
                ingredients = :ingredients,
                tools = :tools,
                instructions = :instructions,
                description = :description,
                tags = :tags
            where id = :id and is_custom = true
        """
    }

    fun getCocktailNames(name: String): List<CocktailName> {
        return namedJdbcTemplate.query(
            GET_COCKTAIL_NAMES,
            MapSqlParameterSource()
                .addValue("name", "%$name%")
                .addValue("limit", LIMIT)
        ) { rs, _ -> CocktailName(rs.getInt("id"), rs.getString("name")) }
    }

    fun getLightCocktails(name: String, start: Int, limit: Int): List<PagedCocktailLight> {
        val cocktails = LinkedHashMap<Int, PagedCocktailLight>()
        namedJdbcTemplate.query(
            GET_LIGHT_COCKTAILS,
            MapSqlParameterSource()
                .addValue("name", "%$name%")
                .addValue("id", start)
                .addValue("limit", limit)
        ) { rs ->
            run {
                val cocktailId = rs.getInt("cid")
                val cocktailLight = cocktails.computeIfAbsent(
                    cocktailId
                ) { id ->
                    PagedCocktailLight(
                        id,
                        rs.getString("cname"),
                        rs.getBytes("cpreview"),
                        0,
                        ArrayList()
                    )
                }

                val cocktailIngredient = CocktailIngredient(
                    rs.getInt("iid"),
                    rs.getString("iname"),
                    rs.getBytes("ipreview"),
                    IngredientType.fromType(rs.getString("itype")),
                    rs.getInt("ciamount"),
                    rs.getString("ciunit")
                )

                cocktailLight.ingredients.add(cocktailIngredient)
            }
        }
        return ArrayList(cocktails.values)
    }

    fun getCocktail(id: Int): Cocktail {
        val cocktails = HashMap<Int, Cocktail>()
        namedJdbcTemplate.query(
            GET_COCKTAIL,
            MapSqlParameterSource("id", id)
        ) {
            rs ->
            run {
                val cocktailId = rs.getInt("cid")
                val cocktailLight = cocktails.computeIfAbsent(
                    cocktailId
                ) { id ->
                    Cocktail(
                        id,
                        rs.getString("cname"),
                        rs.getBytes("cimage"),
                        ArrayList(),
                        ArrayList(),
                        (rs.getArray("ctools").array as Array<Int>).toList(),
                        (rs.getArray("cinstructions").array as Array<String>).toList(),
                        rs.getString("cdescription"),
                        (rs.getArray("ctags").array as Array<String>).toList(),
                        rs.getBoolean("ciscustom")
                    )
                }

                val cocktailIngredient = CocktailIngredient(
                    rs.getInt("iid"),
                    rs.getString("iname"),
                    rs.getBytes("ipreview"),
                    IngredientType.fromType(rs.getString("itype")),
                    rs.getInt("ciamount"),
                    rs.getString("ciunit")
                )

                cocktailLight.ingredients.add(cocktailIngredient)
            }
        }

        val cocktail = cocktails[id]!!
        cocktail.tools.addAll(getTools(cocktail.toolIds))
        return cocktail
    }

    fun getTools(ids: List<Int>): List<CocktailTool> {
        return namedJdbcTemplate.query(
            GET_TOOLS,
            MapSqlParameterSource("ids", ids)
        ) {rs, _ -> CocktailTool(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getBytes("preview")
        )}
    }

    fun getCocktailsByIngredient(ingredientId: Int, start: Int, limit: Int): List<CocktailLight> {
        val cocktails = HashMap<Int, CocktailLight>()
        namedJdbcTemplate.query(
            GET_LIGHT_COCKTAILS_BY_INGREDIENT_ID,
            MapSqlParameterSource()
                .addValue("ingredientId", ingredientId)
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
                        ArrayList(),
                        rs.getBoolean("ciscustom")
                    )
                }

                val cocktailIngredient = CocktailIngredient(
                    rs.getInt("iid"),
                    rs.getString("iname"),
                    rs.getBytes("ipreview"),
                    IngredientType.fromType(rs.getString("itype")),
                    rs.getInt("ciamount"),
                    rs.getString("ciunit")
                )

                cocktailLight.ingredients.add(cocktailIngredient)
            }
        }
        return ArrayList(cocktails.values)
    }

    fun getCocktailsByIngredientIds(ingredientIds: Collection<Int>, start: Int, limit: Int): List<CocktailLight> {
        val cocktails = HashMap<Int, CocktailLight>()
        namedJdbcTemplate.query(
            GET_LIGHT_COCKTAILS_BY_INGREDIENT_IDS,
            MapSqlParameterSource()
                .addValue("ingredientIds", ArraySql.create(ingredientIds, JDBCType.INTEGER))
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
                        ArrayList(),
                        rs.getBoolean("ciscustom")
                    )
                }

                val cocktailIngredient = CocktailIngredient(
                    rs.getInt("iid"),
                    rs.getString("iname"),
                    rs.getBytes("ipreview"),
                    IngredientType.fromType(rs.getString("itype")),
                    rs.getInt("ciamount"),
                    rs.getString("ciunit")
                )

                cocktailLight.ingredients.add(cocktailIngredient)
            }
        }
        return ArrayList(cocktails.values)
    }

    fun getAllCocktailsByIngredientIds(
        ingredientIds: Collection<Int>,
        start: Int,
        limit: Int
    ): List<PagedCocktailLight> {
        val cocktails = HashMap<Int, PagedCocktailLight>()
        namedJdbcTemplate.query(
            GET_ALL_LIGHT_COCKTAILS_BY_INGREDIENT_IDS,
            MapSqlParameterSource()
                .addValue("ingredientIds", ArraySql.create(ingredientIds, JDBCType.INTEGER))
                .addValue("start", start)
                .addValue("limit", limit)
        ) { rs ->
            run {
                val cocktailId = rs.getInt("cid")
                val cocktailLight = cocktails.computeIfAbsent(
                    cocktailId
                ) { id ->
                    PagedCocktailLight(
                        id,
                        rs.getString("cname"),
                        rs.getBytes("cpreview"),
                        rs.getInt("missing_count"),
                        ArrayList()
                    )
                }

                val cocktailIngredient = CocktailIngredient(
                    rs.getInt("iid"),
                    rs.getString("iname"),
                    rs.getBytes("ipreview"),
                    IngredientType.fromType(rs.getString("itype")),
                    rs.getInt("ciamount"),
                    rs.getString("ciunit")
                )

                cocktailLight.ingredients.add(cocktailIngredient)
            }
        }
        return ArrayList(cocktails.values)
    }

    fun getCocktailsByIds(ids: List<Int>, start: Int, limit: Int): List<CocktailLight> {
        val cocktails = HashMap<Int, CocktailLight>()
        namedJdbcTemplate.query(
            GET_LIGHT_COCKTAILS_BY_IDS,
            MapSqlParameterSource()
                .addValue("ids", ids)
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
                        ArrayList(),
                        rs.getBoolean("ciscustom")
                    )
                }

                val cocktailIngredient = CocktailIngredient(
                    rs.getInt("iid"),
                    rs.getString("iname"),
                    rs.getBytes("ipreview"),
                    IngredientType.fromType(rs.getString("itype")),
                    rs.getInt("ciamount"),
                    rs.getString("ciunit")
                )

                cocktailLight.ingredients.add(cocktailIngredient)
            }
        }
        return ArrayList(cocktails.values)
    }

    fun saveCocktail(saveCocktail: SaveCocktail): Int {
        val generatedKeyHolder = GeneratedKeyHolder()
        namedJdbcTemplate.update(
            SAVE_COCKTAIL,
            MapSqlParameterSource()
                .addValue("name", saveCocktail.name)
                .addValue("image", saveCocktail.image)
                .addValue("preview", saveCocktail.preview)
                .addValue("ingredients", ArraySql.create(saveCocktail.ingredients.map { it.id }, JDBCType.INTEGER))
                .addValue("tools", ArraySql.create(saveCocktail.toolIds, JDBCType.INTEGER))
                .addValue("instructions", ArraySql.create(saveCocktail.instructions, JDBCType.VARCHAR))
                .addValue("description", saveCocktail.description)
                .addValue("tags", ArraySql.create(saveCocktail.tags, JDBCType.VARCHAR)),
            generatedKeyHolder,
            arrayOf("id")
        )
        return generatedKeyHolder.key!!.toInt()
    }

    fun updateCocktail(saveCocktail: SaveCocktail): Int {
        return namedJdbcTemplate.update(
            UPDATE_COCKTAIL,
            MapSqlParameterSource()
                .addValue("id", saveCocktail.id!!)
                .addValue("name", saveCocktail.name)
                .addValue("image", saveCocktail.image)
                .addValue("preview", saveCocktail.preview)
                .addValue("ingredients", ArraySql.create(saveCocktail.ingredients.map { it.id }, JDBCType.INTEGER))
                .addValue("tools", ArraySql.create(saveCocktail.toolIds, JDBCType.INTEGER))
                .addValue("instructions", ArraySql.create(saveCocktail.instructions, JDBCType.VARCHAR))
                .addValue("description", saveCocktail.description)
                .addValue("tags", ArraySql.create(saveCocktail.tags, JDBCType.VARCHAR))
        )
    }
}
