package org.openapitools.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.Valid

/**
 * 
 * @param hasNext 
 * @param nextStart 
 * @param cocktails 
 */
data class PagedCocktailLightResponse(

    @Schema(example = "null", description = "")
    @field:JsonProperty("hasNext") val hasNext: kotlin.Boolean? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("nextStart") val nextStart: kotlin.Int? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @field:JsonProperty("cocktails") val cocktails: kotlin.collections.List<CocktailLightDTO>? = null
) {

}

