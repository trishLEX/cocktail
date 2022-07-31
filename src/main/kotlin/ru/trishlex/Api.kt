package ru.trishlex

import org.openapitools.api.DefaultApi
import org.openapitools.model.PingResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class Api : DefaultApi {

    override fun ping(): ResponseEntity<PingResponse> {
        throw UnsupportedOperationException()
        return ResponseEntity.ok(PingResponse("hello world!"))
    }
}