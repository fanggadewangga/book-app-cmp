package com.fangga.book_app_cmp.book.data.network

import com.fangga.book_app_cmp.book.data.dto.BookWorkDto
import com.fangga.book_app_cmp.book.data.dto.SearchResponseDto
import com.fangga.book_app_cmp.core.domain.DataError
import com.fangga.book_app_cmp.core.domain.Result

interface RemoteBookDatasource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote>
}