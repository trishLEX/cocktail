package org.openapitools.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param id 
 * @param name 
 * @param preview 
 * @param amount 
 * @param unit 
 */
data class CocktailIngredient(

    @Schema(example = "null", description = "")
    @field:JsonProperty("id") val id: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("name") val name: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("preview") val preview: kotlin.ByteArray? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("amount") val amount: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("unit") val unit: kotlin.String? = null
) {

}

