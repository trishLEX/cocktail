package org.openapitools.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param response 
 */
data class PingResponse(

    @Schema(example = "null", description = "")
    @field:JsonProperty("response") val response: kotlin.String? = null
) {

}

