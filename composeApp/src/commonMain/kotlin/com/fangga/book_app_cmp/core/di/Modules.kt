package com.fangga.book_app_cmp.core.di

import com.fangga.book_app_cmp.book.data.network.KtorRemoteBookDatasource
import com.fangga.book_app_cmp.book.data.network.RemoteBookDatasource
import com.fangga.book_app_cmp.book.data.repository.DefaultBookRepository
import com.fangga.book_app_cmp.book.domain.BookRepository
import com.fangga.book_app_cmp.book.presentation.book_list.BookListViewModel
import com.fangga.book_app_cmp.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDatasource).bind<RemoteBookDatasource>()
    // singleOf :: to handle multiple arguments
    // bind to define the abstraction because KtorRemoteBookDatasource is implementation detail
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    viewModelOf(::BookListViewModel)
}