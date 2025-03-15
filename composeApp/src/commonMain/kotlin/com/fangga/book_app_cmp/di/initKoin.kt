package com.fangga.book_app_cmp.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

// call this init on every platform entry point
fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(sharedModule, platformModule)
    }
}