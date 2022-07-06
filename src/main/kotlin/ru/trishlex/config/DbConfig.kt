package ru.trishlex.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import javax.sql.DataSource

@Configuration
class DbConfig {

    @Bean
    fun dataSource(
        @Value("\${db.url}") url: String,
        @Value("\${db.driver}") driver: String,
        @Value("\${db.username}") user: String,
        @Value("\${db.password}") password: String
    ): DataSource {
        val hikariConfig = HikariConfig()
        hikariConfig.setDriverClassName(driver)
        hikariConfig.jdbcUrl = url
        hikariConfig.username = user
        hikariConfig.password = password
        return HikariDataSource(hikariConfig)
    }

    @Bean
    fun namedJdbcTemplate(dataSource: DataSource): NamedParameterJdbcTemplate {
        return NamedParameterJdbcTemplate(dataSource)
    }
}