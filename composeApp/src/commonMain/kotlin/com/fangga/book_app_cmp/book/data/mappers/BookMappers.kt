package com.fangga.book_app_cmp.book.data.mappers

import com.fangga.book_app_cmp.book.data.database.BookEntity
import com.fangga.book_app_cmp.book.data.dto.SearchedBookDto
import com.fangga.book_app_cmp.book.domain.Book

fun SearchedBookDto.toBook() = Book(
    id = id.substringAfterLast("/"),
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

fun Book.toBookEntity(): BookEntity {
    return BookEntity(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        languages = languages,
        authors = authors,
        firstPublishYear = firstPublishedYear,
        ratingsAverage = averageRating,
        ratingsCount = ratingCount,
        numPagesMedian = numPages,
        numEditions = numEditions
    )
}

fun BookEntity.toBook(): Book {
    return Book(
        id = id,
        title = title,
        description = description,
        imageUrl = imageUrl,
        languages = languages,
        authors = authors,
        firstPublishedYear = firstPublishYear,
        averageRating = ratingsAverage,
        ratingCount = ratingsCount,
        numPages = numPagesMedian,
        numEditions = numEditions
    )
}