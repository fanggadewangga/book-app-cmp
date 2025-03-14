package com.fangga.book_app_cmp

import androidx.compose.ui.window.ComposeUIViewController
import com.fangga.book_app_cmp.app.App
import com.fangga.book_app_cmp.core.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) {
    App()
}