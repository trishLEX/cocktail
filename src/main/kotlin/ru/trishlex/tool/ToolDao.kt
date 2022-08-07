package ru.trishlex.tool

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import ru.trishlex.tool.model.ToolLight

@Repository
class ToolDao(private val namedJdbcTemplate: NamedParameterJdbcTemplate) {

    companion object {
        private const val GET_TOOLS = "select id, name, preview from tool"
    }

    fun getTools(): List<ToolLight> {
        return namedJdbcTemplate.query(
            GET_TOOLS
        ) { rs, _ ->
            ToolLight(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getBytes("preview")
            )
        }
    }
}