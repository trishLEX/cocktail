package org.openapitools.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.Valid

/**
 * 
 * @param id 
 * @param name 
 * @param preview 
 * @param missingIngredientsCount 
 * @param ingredients 
 */
data class CocktailLightDTO(

    @Schema(example = "null", description = "")
    @field:JsonProperty("id") val id: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("name") val name: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("preview") val preview: kotlin.ByteArray? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("missingIngredientsCount") val missingIngredientsCount: kotlin.Int? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @field:JsonProperty("ingredients") val ingredients: kotlin.collections.List<CocktailIngredientDTO>? = null
) {

}

