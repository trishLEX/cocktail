package ru.trishlex.cocktail

import org.openapitools.api.CocktailApi
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class CocktailController(private val cocktailService: CocktailService) : CocktailApi {

    override fun getCocktailNames(name: String): ResponseEntity<List<String>> {
        return ResponseEntity.ok(cocktailService.getCocktailNames(name))
    }

}