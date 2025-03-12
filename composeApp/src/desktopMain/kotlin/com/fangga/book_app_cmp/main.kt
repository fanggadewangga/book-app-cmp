package com.fangga.book_app_cmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "book-app-cmp",
    ) {
        App()
    }
}