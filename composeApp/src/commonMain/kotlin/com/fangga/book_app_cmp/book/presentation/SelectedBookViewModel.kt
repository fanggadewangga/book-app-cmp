package com.fangga.book_app_cmp.book.presentation

import androidx.lifecycle.ViewModel
import com.fangga.book_app_cmp.book.domain.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

// just create the logic to be shared, don't put all logics for many screens
class SelectedBookViewModel: ViewModel() {

    private val _selectedBook = MutableStateFlow<Book?>(null)
    val selectedBook = _selectedBook.asStateFlow()

    fun onSelectBook(book: Book?) {
        _selectedBook.value = book
    }
}