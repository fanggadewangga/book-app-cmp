package com.fangga.book_app_cmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.fangga.book_app_cmp.books.presentation.book_list.BookListScreenRoot
import com.fangga.book_app_cmp.books.presentation.book_list.BookListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    BookListScreenRoot(
        viewModel = remember { BookListViewModel() },
        onBookClick = {},
    )
}