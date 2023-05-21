package ru.trishlex.cocktail

import org.openapitools.api.CocktailApi
import org.openapitools.model.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import ru.trishlex.cocktail.model.SaveCocktail
import ru.trishlex.util.injectedLogger

@RestController
class CocktailController(private val cocktailService: CocktailService) : CocktailApi {

    private val log by injectedLogger()

    override fun getCocktailNames(name: String, requestId: String?): ResponseEntity<List<CocktailNameDTO>> {
        return ResponseEntity.ok(cocktailService.getCocktailNames(name).map { it.toDTO() })
    }

    override fun getCocktails(name: String, start: Int?, limit: Int?, requestId: String?): ResponseEntity<List<CocktailLightDTO>> {
        return ResponseEntity.ok(cocktailService.getLightCocktails(name, start, limit).cocktails.map { it.toDto() })
    }

    override fun getCocktail(id: Int, requestId: String?): ResponseEntity<CocktailDTO> {
        return ResponseEntity.ok(cocktailService.getCocktail(id).toDto())
    }

    override fun getCocktailsByIngredient(id: Int, start: Int?, limit: Int?, requestId: String?): ResponseEntity<List<CocktailLightDTO>> {
        return ResponseEntity.ok(cocktailService.getLightCocktails(id, start, limit).map { it.toDto() })
    }

    override fun getCocktailsByIngredients(
        ingredientIds: List<Int>,
        start: Int?,
        limit: Int?,
        requestId: String?
    ): ResponseEntity<List<CocktailLightDTO>> {
        return ResponseEntity.ok(cocktailService.getLightCocktails(ingredientIds.toHashSet(), start, limit).map { it.toDto() })
    }

    override fun getAllCocktailsByIngredients(
        ingredientIds: List<Int>,
        start: Int?,
        limit: Int?,
        requestId: String?
    ): ResponseEntity<PagedCocktailLightResponse> {
        return ResponseEntity.ok(
            cocktailService.getAllLightCocktails(ingredientIds.toHashSet(), start, limit).toDto()
        )
    }

    override fun getCocktailsByIds(ids: List<Int>, start: Int?, limit: Int?, requestId: String?): ResponseEntity<List<CocktailLightDTO>> {
        return ResponseEntity.ok(cocktailService.getLightCocktails(ids, start, limit).map { it.toDto() })
    }

    override fun getCocktailsByName(
        name: String,
        start: Int?,
        limit: Int?,
        requestId: String?
    ): ResponseEntity<PagedCocktailLightResponse> {
        return ResponseEntity.ok(cocktailService.getLightCocktails(name, start, limit).toDto())
    }

    override fun saveCocktail(requestId: String?, saveCocktailRequestDTO: SaveCocktailRequestDTO?): ResponseEntity<Unit> {
        cocktailService.saveCocktail(SaveCocktail(saveCocktailRequestDTO!!))
        return ResponseEntity.ok().build()
    }
}