package ru.trishlex.ingredient

import org.openapitools.api.IngredientApi
import org.openapitools.model.IngredientNameDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class IngredientController(private val ingredientService: IngredientService): IngredientApi {

    override fun getIngredientNames(name: String): ResponseEntity<List<IngredientNameDTO>> {
        return ResponseEntity.ok(ingredientService.getIngredientNames(name).map { it.toDto() })
    }
}