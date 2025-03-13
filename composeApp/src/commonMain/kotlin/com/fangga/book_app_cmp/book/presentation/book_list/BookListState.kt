package com.fangga.book_app_cmp.book.presentation.book_list

import com.fangga.book_app_cmp.book.domain.Book
import com.fangga.book_app_cmp.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "Kotlin",
    val searchResults: List<Book> = books,
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)

val books = (1..100).map { it ->
    Book(
        id = it.toString(),
        title = "Book $it",
        imageUrl = it.toString(),
        authors = listOf("tes"),
        description = "Description $it",
        languages = emptyList(),
        firstPublishedYear = null,
        averageRating = 4.6789,
        ratingCount = 5,
        numPages = it,
        numEditions = it,
    )
}
