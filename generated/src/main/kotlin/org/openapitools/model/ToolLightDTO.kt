package org.openapitools.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param id 
 * @param preview 
 * @param name 
 */
data class ToolLightDTO(

    @Schema(example = "null", description = "")
    @field:JsonProperty("id") val id: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("preview") val preview: kotlin.ByteArray? = null,

    @Schema(example = "null", description = "")
    @field:JsonProperty("name") val name: kotlin.String? = null
) {

}

