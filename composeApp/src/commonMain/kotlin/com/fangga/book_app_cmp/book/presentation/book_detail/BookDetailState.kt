package com.fangga.book_app_cmp.book.presentation.book_detail

import com.fangga.book_app_cmp.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null,
)
