package com.fangga.book_app_cmp.book.data.mappers

import com.fangga.book_app_cmp.book.data.dto.SearchedBookDto
import com.fangga.book_app_cmp.book.domain.Book

fun SearchedBookDto.toBook() = Book(
    id = id,
    title = title,
    imageUrl = if (coverKey != null) {
        "https://covers.openlibrary.org/b/olid/${coverKey}-L.jpg"
    } else {
        "https://covers.openlibrary.org/b/olid/${coverAlternativeKey}-L.jpg"
    },
    authors = authorNames ?: emptyList(),
    description = null,
    languages = languages ?: emptyList(),
    firstPublishedYear = publishYear.toString(),
    averageRating = ratingsAverage,
    ratingCount = ratingsCount,
    numPages = numPagesMedian,
    numEditions = numEditions ?: 0
)