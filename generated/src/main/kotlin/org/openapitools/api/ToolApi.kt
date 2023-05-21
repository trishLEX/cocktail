/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
*/
package org.openapitools.api

import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.openapitools.model.ToolLightDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Validated
@RequestMapping("\${api.base-path:}")
interface ToolApi {

    @Operation(
        summary = "",
        operationId = "getTools",
        description = "",
        responses = [
            ApiResponse(responseCode = "200", description = "OK", content = [Content(schema = Schema(implementation = ToolLightDTO::class))])
        ]
    )
    @RequestMapping(
            method = [RequestMethod.GET],
            value = ["/tools/types"],
            produces = ["application/json"]
    )
    fun getTools(@Parameter(description = "", `in` = ParameterIn.HEADER) @RequestHeader(value = "requestId", required = false) requestId: kotlin.String?): ResponseEntity<List<ToolLightDTO>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}