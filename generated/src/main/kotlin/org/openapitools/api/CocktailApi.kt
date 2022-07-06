/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
*/
package org.openapitools.api

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.openapitools.model.CocktailDTO
import org.openapitools.model.CocktailLightDTO
import org.openapitools.model.CocktailNameDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import javax.validation.Valid
import javax.validation.constraints.NotNull

@Validated
@RequestMapping("\${api.base-path:}")
interface CocktailApi {

    @Operation(
        summary = "",
        operationId = "getCocktail",
        description = "",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = CocktailDTO::class))])
        ]
    )
    @RequestMapping(
            method = [RequestMethod.GET],
            value = ["/cocktails/{id}"],
            produces = ["application/json"]
    )
    fun getCocktail(@Parameter(description = "", required = true) @PathVariable("id") id: kotlin.Int): ResponseEntity<CocktailDTO> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "",
        operationId = "getCocktailNames",
        description = "",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = CocktailNameDTO::class))])
        ]
    )
    @RequestMapping(
            method = [RequestMethod.GET],
            value = ["/cocktail-names/{name}"],
            produces = ["application/json"]
    )
    fun getCocktailNames(@Parameter(description = "", required = true) @PathVariable("name") name: kotlin.String): ResponseEntity<List<CocktailNameDTO>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "",
        operationId = "getCocktails",
        description = "",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = CocktailLightDTO::class))])
        ]
    )
    @RequestMapping(
            method = [RequestMethod.GET],
            value = ["/cocktails"],
            produces = ["application/json"]
    )
    fun getCocktails(@NotNull @Parameter(description = "", required = true) @Valid @RequestParam(value = "name", required = true) name: kotlin.String,@Parameter(description = "") @Valid @RequestParam(value = "start", required = false) start: kotlin.Int?,@Parameter(description = "") @Valid @RequestParam(value = "limit", required = false) limit: kotlin.Int?): ResponseEntity<List<CocktailLightDTO>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
