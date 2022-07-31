package ru.trishlex.api

import org.springframework.stereotype.Component
import org.springframework.web.servlet.AsyncHandlerInterceptor
import ru.trishlex.util.injectedLogger
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class LogRequestInterceptor : AsyncHandlerInterceptor {

    private val log by injectedLogger()

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        log.info("Request: " + request.requestURL.toString() + " time: " + LocalDateTime.now())
        return super.preHandle(request, response, handler)
    }
}