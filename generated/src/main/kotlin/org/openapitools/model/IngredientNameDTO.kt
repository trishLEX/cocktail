package org.openapitools.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param id 
 * @param name 
 */
data class IngredientNameDTO(

    @Schema(example = "null", required = true, description = "")
    @field:JsonProperty("id", required = true) val id: kotlin.Int,

    @Schema(example = "null", required = true, description = "")
    @field:JsonProperty("name", required = true) val name: kotlin.String
) {

}

