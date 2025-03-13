package com.fangga.book_app_cmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.fangga.book_app_cmp.book.presentation.book_list.BookListScreen
import com.fangga.book_app_cmp.book.presentation.book_list.BookListState
import com.fangga.book_app_cmp.book.presentation.book_list.components.BookSearchBar

@Preview(backgroundColor = 0xFFFFFF)
@Composable
private fun BookSearchBarPreview() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
        ) {
            BookSearchBar(
                searchQuery = "Kotlin",
                onSearchQueryChange = {},
                onImeSearch = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
private fun BookScreenPreview() {
    MaterialTheme {
        BookListScreen(
            state = BookListState(),

        ) { }
    }
}