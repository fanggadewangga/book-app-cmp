package com.fangga.book_app_cmp.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.fangga.book_app_cmp.book.data.database.DatabaseFactory
import com.fangga.book_app_cmp.book.data.database.FavoriteBookDatabase
import com.fangga.book_app_cmp.book.data.network.KtorRemoteBookDatasource
import com.fangga.book_app_cmp.book.data.network.RemoteBookDatasource
import com.fangga.book_app_cmp.book.data.repository.DefaultBookRepository
import com.fangga.book_app_cmp.book.domain.BookRepository
import com.fangga.book_app_cmp.book.presentation.book_detail.BookDetailViewModel
import com.fangga.book_app_cmp.book.presentation.book_list.BookListViewModel
import com.fangga.book_app_cmp.book.presentation.SelectedBookViewModel
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

    single {
        get<DatabaseFactory>()
            .create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModelOf(::BookListViewModel)
    viewModelOf(::SelectedBookViewModel)
    viewModelOf(::BookDetailViewModel)
}