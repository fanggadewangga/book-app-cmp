package com.fangga.book_app_cmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.fangga.book_app_cmp.app.App
import com.fangga.book_app_cmp.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "book-app-cmp",
        ) {
            App()
        }
    }
}