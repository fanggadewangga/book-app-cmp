package com.fangga.book_app_cmp.book.presentation.book_list

import com.fangga.book_app_cmp.book.domain.Book

sealed interface BookListAction {
    data class OnSearchQueryChange(val query: String) : BookListAction
    data class OnBookClick(val book: Book) : BookListAction
    data class OnTabSelected(val index: Int) : BookListAction
}