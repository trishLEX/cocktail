package org.openapitools.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param response 
 */
data class PingResponse(

    @Schema(example = "null", required = true, description = "")
    @field:JsonProperty("response", required = true) val response: kotlin.String
) {

}

