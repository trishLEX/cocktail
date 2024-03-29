package ru.trishlex.ingredient

import org.openapitools.api.IngredientApi
import org.openapitools.model.IngredientDTO
import org.openapitools.model.IngredientLightDTO
import org.openapitools.model.IngredientNameDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class IngredientController(private val ingredientService: IngredientService): IngredientApi {

    override fun getIngredientNames(name: String, requestId: String?): ResponseEntity<List<IngredientNameDTO>> {
        return ResponseEntity.ok(ingredientService.getIngredientNames(name).map { it.toDto() })
    }

    override fun getIngredient(id: Int, requestId: String?): ResponseEntity<IngredientDTO> {
        return ResponseEntity.ok(ingredientService.getIngredient(id).toDto())
    }

    override fun getIngredients(name: String, start: Int?, limit: Int?, requestId: String?): ResponseEntity<List<IngredientLightDTO>> {
        return ResponseEntity.ok(ingredientService.getIngredients(name, start, limit).map { it.toDto() })
    }

    override fun getIngredientsByIds(ids: List<Int>, requestId: String?): ResponseEntity<List<IngredientLightDTO>> {
        return ResponseEntity.ok(ingredientService.getIngredients(ids).map { it.toDto() })
    }

    override fun getIngredientTypes(requestId: String?): ResponseEntity<List<IngredientLightDTO>> {
        return ResponseEntity.ok(ingredientService.getSearchIngredients().map { it.toDto() })
    }
}