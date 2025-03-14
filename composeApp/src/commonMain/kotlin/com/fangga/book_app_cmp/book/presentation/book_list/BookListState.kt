package com.fangga.book_app_cmp.book.presentation.book_list

import com.fangga.book_app_cmp.book.domain.Book
import com.fangga.book_app_cmp.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = true,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)