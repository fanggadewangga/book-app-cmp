package com.fangga.book_app_cmp.book.data.repository

import com.fangga.book_app_cmp.book.data.mappers.toBook
import com.fangga.book_app_cmp.book.data.network.RemoteBookDatasource
import com.fangga.book_app_cmp.book.domain.Book
import com.fangga.book_app_cmp.book.domain.BookRepository
import com.fangga.book_app_cmp.core.domain.DataError
import com.fangga.book_app_cmp.core.domain.Result
import com.fangga.book_app_cmp.core.domain.map

class DefaultBookRepository(
    private val remoteBookDatasource: RemoteBookDatasource
): BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDatasource
            .searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }
}