package ru.trishlex.cocktail

import org.openapitools.api.CocktailApi
import org.openapitools.model.CocktailDTO
import org.openapitools.model.CocktailLightDTO
import org.openapitools.model.CocktailNameDTO
import org.openapitools.model.PagedCocktailLightResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class CocktailController(private val cocktailService: CocktailService) : CocktailApi {

    override fun getCocktailNames(name: String): ResponseEntity<List<CocktailNameDTO>> {
        return ResponseEntity.ok(cocktailService.getCocktailNames(name).map { it.toDTO() })
    }

    override fun getCocktails(name: String, start: Int?, limit: Int?): ResponseEntity<List<CocktailLightDTO>> {
        return ResponseEntity.ok(cocktailService.getLightCocktails(name, start, limit).cocktails.map { it.toDto() })
    }

    override fun getCocktail(id: Int): ResponseEntity<CocktailDTO> {
        return ResponseEntity.ok(cocktailService.getCocktail(id).toDto())
    }

    override fun getCocktailsByIngredient(id: Int, start: Int?, limit: Int?): ResponseEntity<List<CocktailLightDTO>> {
        return ResponseEntity.ok(cocktailService.getLightCocktails(id, start, limit).map { it.toDto() })
    }

    override fun getCocktailsByIngredients(
        ingredientIds: List<Int>,
        start: Int?,
        limit: Int?
    ): ResponseEntity<List<CocktailLightDTO>> {
        return ResponseEntity.ok(cocktailService.getLightCocktails(ingredientIds.toHashSet(), start, limit).map { it.toDto() })
    }

    override fun getAllCocktailsByIngredients(
        ingredientIds: List<Int>,
        start: Int?,
        limit: Int?
    ): ResponseEntity<PagedCocktailLightResponse> {
        return ResponseEntity.ok(
            cocktailService.getAllLightCocktails(ingredientIds.toHashSet(), start, limit).toDto()
        )
    }

    override fun getCocktailsByIds(ids: List<Int>, start: Int?, limit: Int?): ResponseEntity<List<CocktailLightDTO>> {
        return ResponseEntity.ok(cocktailService.getLightCocktails(ids, start, limit).map { it.toDto() })
    }

    override fun getCocktailsByName(
        name: String,
        start: Int?,
        limit: Int?
    ): ResponseEntity<PagedCocktailLightResponse> {
        return ResponseEntity.ok(cocktailService.getLightCocktails(name, start, limit).toDto())
    }
}