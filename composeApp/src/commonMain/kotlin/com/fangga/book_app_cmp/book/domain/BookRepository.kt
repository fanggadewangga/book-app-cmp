package com.fangga.book_app_cmp.book.domain

import com.fangga.book_app_cmp.core.domain.DataError
import com.fangga.book_app_cmp.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
    suspend fun getBookDescription(bookId: String): Result<String?, DataError>
}