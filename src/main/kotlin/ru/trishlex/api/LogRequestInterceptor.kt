package ru.trishlex.api

import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import ru.trishlex.util.injectedLogger
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class LogRequestInterceptor : HandlerInterceptor {

    private val log by injectedLogger()

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        var ipAddress = request.getHeader("X-Forward-For")
        val requestId = request.getHeader("requestId")

        if (ipAddress == null) {
            ipAddress = request.remoteAddr
        }
        log.info("Got Request: id:$requestId ${request.requestURL}\tparams: ${request.parameterMap}\tip: $ipAddress")
        return super.preHandle(request, response, handler)
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) {
        val requestId = request.getHeader("requestId")
        log.info("Done Request: id:$requestId ${request.requestURL}\tparams: ${request.parameterMap}\t")
        super.postHandle(request, response, handler, modelAndView)
    }
}