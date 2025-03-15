package com.fangga.book_app_cmp.book.data.repository

import androidx.sqlite.SQLiteException
import com.fangga.book_app_cmp.book.data.database.FavoriteBookDao
import com.fangga.book_app_cmp.book.data.mappers.toBook
import com.fangga.book_app_cmp.book.data.mappers.toBookEntity
import com.fangga.book_app_cmp.book.data.network.RemoteBookDatasource
import com.fangga.book_app_cmp.book.domain.Book
import com.fangga.book_app_cmp.book.domain.BookRepository
import com.fangga.book_app_cmp.core.domain.DataError
import com.fangga.book_app_cmp.core.domain.EmptyResult
import com.fangga.book_app_cmp.core.domain.Result
import com.fangga.book_app_cmp.core.domain.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultBookRepository(
    private val remoteBookDatasource: RemoteBookDatasource,
    private val favoriteBookDao: FavoriteBookDao
) : BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDatasource
            .searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        val localResult = favoriteBookDao.getFavoriteBookById(bookId)
        return if (localResult == null) {
            remoteBookDatasource
                .getBookDetails(bookId)
                .map { it.description }
        } else {
            Result.Success(localResult.description)
        }
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return favoriteBookDao
            .getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.map {
                    it.toBook()
                }
            }
    }

    override fun isBookFavorite(id: String): Flow<Boolean> {
        return favoriteBookDao
            .getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.any { it.id == id }
            }
    }

    override suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local> {
        return try {
            favoriteBookDao.upsert(book.toBookEntity())
            Result.Success(Unit)
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFromFavorite(id: String) {
        favoriteBookDao.deleteFavoriteBook(id)
    }
}