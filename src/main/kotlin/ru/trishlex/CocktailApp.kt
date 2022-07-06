package ru.trishlex

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["org.openapitools", "ru.trishlex"])
class CocktailApp : SpringBootServletInitializer()

fun main(args: Array<String>) {
    runApplication<CocktailApp>(*args)
}