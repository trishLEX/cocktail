package ru.trishlex.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class RequestAppConfiguration : WebMvcConfigurer {

    @Autowired
    private lateinit var logRequestInterceptor: LogRequestInterceptor

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(logRequestInterceptor)
    }
}