package ru.trishlex.cocktail

import org.openapitools.api.CocktailApi
import org.openapitools.model.CocktailDTO
import org.openapitools.model.CocktailLightDTO
import org.openapitools.model.CocktailNameDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class CocktailController(private val cocktailService: CocktailService) : CocktailApi {

    override fun getCocktailNames(name: String): ResponseEntity<List<CocktailNameDTO>> {
        return ResponseEntity.ok(cocktailService.getCocktailNames(name).map { it.toDTO() })
    }

    override fun getCocktails(name: String, start: Int?, limit: Int?): ResponseEntity<List<CocktailLightDTO>> {
        return ResponseEntity.ok(cocktailService.getLightCocktails(name, start, limit).map { it.toDto() })
    }

    override fun getCocktail(id: Int): ResponseEntity<CocktailDTO> {
        return ResponseEntity.ok(cocktailService.getCocktail(id).toDto())
    }
}