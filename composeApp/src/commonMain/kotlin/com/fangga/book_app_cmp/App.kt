package com.fangga.book_app_cmp

import androidx.compose.runtime.Composable
import com.fangga.book_app_cmp.book.presentation.book_list.BookListScreenRoot
import com.fangga.book_app_cmp.book.presentation.book_list.BookListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    val viewModel = koinViewModel<BookListViewModel>()

    BookListScreenRoot(
        viewModel = viewModel,
        onBookClick = {},
    )
}