package com.fangga.book_app_cmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform