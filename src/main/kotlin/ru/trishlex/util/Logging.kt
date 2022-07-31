package ru.trishlex.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass
import kotlin.reflect.full.companionObject

fun <T : Any> unwrapCompanionClass(ofClass: Class<T>): Class<*> {
    return ofClass.enclosingClass?.takeIf {
        ofClass.enclosingClass.kotlin.companionObject?.java == ofClass
    } ?: ofClass
}

fun <T : Any> logger(forClass: Class<T>): Logger {
    return LoggerFactory.getLogger(unwrapCompanionClass(forClass).name)
}

fun <T : Any> logger(forClass: KClass<T>): Logger {
    return logger(forClass.java)
}

fun <R : Any> R.injectedLogger(): Lazy<Logger> {
    return lazyOf(logger(this.javaClass))
}