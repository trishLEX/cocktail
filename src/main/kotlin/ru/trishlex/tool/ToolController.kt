package ru.trishlex.tool

import org.openapitools.api.ToolApi
import org.openapitools.model.ToolLightDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class ToolController(private val toolService: ToolService): ToolApi {

    override fun getTools(requestId: String?): ResponseEntity<List<ToolLightDTO>> {
        return ResponseEntity.ok(toolService.getTools().map { it.toDto() })
    }
}