package org.openapitools.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param id 
 * @param amount 
 * @param unit 
 */
data class SaveIngredientRequestDTO(

    @Schema(example = "null", description = "")
    @field:JsonProperty("id") val id: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("amount") val amount: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("unit") val unit: kotlin.String? = null
) {

}

