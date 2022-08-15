package org.openapitools.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.Valid

/**
 * 
 * @param id 
 * @param name 
 * @param image 
 * @param preview 
 * @param ingredients 
 * @param tools 
 * @param instructions 
 * @param description 
 * @param tags 
 */
data class SaveCocktailRequestDTO(

    @Schema(example = "null", description = "")
    @field:JsonProperty("id") val id: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("name") val name: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("image") val image: kotlin.ByteArray? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("preview") val preview: kotlin.ByteArray? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @field:JsonProperty("ingredients") val ingredients: kotlin.collections.List<SaveIngredientRequestDTO>? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("tools") val tools: kotlin.collections.List<kotlin.Int>? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("instructions") val instructions: kotlin.collections.List<kotlin.String>? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("description") val description: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("tags") val tags: kotlin.collections.List<kotlin.String>? = null
) {

}

