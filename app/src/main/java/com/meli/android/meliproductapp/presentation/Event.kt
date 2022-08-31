package com.meli.android.meliproductapp.presentation

data class Event<out T>(private val content: T) {

    // si el contenido ha sido manejado
    private var hasbeenHandled = false

    fun getContentIfNotHandled(): T? = if (hasbeenHandled) {
        null
    } else {
        hasbeenHandled = true
        content
    }
}
