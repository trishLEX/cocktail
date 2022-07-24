package org.openapitools.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.Valid

/**
 * 
 * @param types 
 */
data class IngredientTypesResponse(

    @field:Valid
    @Schema(example = "null", description = "")
    @field:JsonProperty("types") val types: kotlin.collections.List<SearchIngredientDTO>? = null
) {

}

