package com.fangga.book_app_cmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.engine.okhttp.OkHttpEngine

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "book-app-cmp",
    ) {
        App( engine = remember { OkHttp.create() } )
    }
}