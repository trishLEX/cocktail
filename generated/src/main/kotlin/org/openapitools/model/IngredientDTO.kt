package org.openapitools.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.Valid

/**
 * 
 * @param id 
 * @param name 
 * @param image 
 * @param type 
 * @param description 
 * @param tags 
 */
data class IngredientDTO(

    @Schema(example = "null", description = "")
    @field:JsonProperty("id") val id: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("name") val name: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("image") val image: kotlin.ByteArray? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @field:JsonProperty("type") val type: IngredientTypeDTO? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("description") val description: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("tags") val tags: kotlin.collections.List<kotlin.String>? = null
) {

}

