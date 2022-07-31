package ru.trishlex.api

import org.springframework.stereotype.Component
import org.springframework.web.servlet.AsyncHandlerInterceptor
import ru.trishlex.util.injectedLogger
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class LogRequestInterceptor : AsyncHandlerInterceptor {

    private val log by injectedLogger()

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        log.info("Request: ${request.requestURL}\tparams: ${request.parameterMap}")
        return super.preHandle(request, response, handler)
    }
}