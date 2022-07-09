package ru.trishlex.util

import org.springframework.jdbc.support.SqlValue
import java.sql.JDBCType
import java.sql.PreparedStatement


class ArraySql<T>(private val array: Array<T>, private val type: JDBCType) : SqlValue {
    override fun setValue(ps: PreparedStatement, paramIndex: Int) {
        val array: java.sql.Array = ps.connection.createArrayOf(type.getName(), array)
        ps.setArray(paramIndex, array)
    }

    override fun cleanup() {}

    companion object {
        fun <T> create(array: Array<T>, type: JDBCType): ArraySql<T> {
            return ArraySql(array, type)
        }

        inline fun <reified T> create(collection: Collection<T>?, type: JDBCType): ArraySql<T>? {
            return if (collection == null) {
                null
            } else ArraySql(collection.toTypedArray(), type)
        }

        fun <T> getList(array: java.sql.Array?): List<T>? {
            return if (array == null) {
                null
            } else (array.array as Array<T>).toList()
        }
    }
}