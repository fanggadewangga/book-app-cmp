package com.fangga.book_app_cmp.book.presentation.book_detail

import com.fangga.book_app_cmp.book.domain.Book

sealed interface BookDetailAction {
    data object OnBackClicked: BookDetailAction
    data object OnFavoriteClicked: BookDetailAction
    data class OnSelectedBookChange(val book: Book): BookDetailAction
}