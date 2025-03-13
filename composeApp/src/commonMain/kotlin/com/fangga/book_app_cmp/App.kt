package com.fangga.book_app_cmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.fangga.book_app_cmp.book.data.network.KtorRemoteBookDatasource
import com.fangga.book_app_cmp.book.data.repository.DefaultBookRepository
import com.fangga.book_app_cmp.book.presentation.book_list.BookListScreenRoot
import com.fangga.book_app_cmp.book.presentation.book_list.BookListViewModel
import com.fangga.book_app_cmp.core.data.HttpClientFactory
import io.ktor.client.engine.HttpClientEngine
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(engine: HttpClientEngine) {
    BookListScreenRoot(
        viewModel = remember { BookListViewModel(
            bookRepository = DefaultBookRepository(
                remoteBookDatasource = KtorRemoteBookDatasource(
                    httpClient = HttpClientFactory.create(engine)
                )
            )
        ) },
        onBookClick = {},
    )
}