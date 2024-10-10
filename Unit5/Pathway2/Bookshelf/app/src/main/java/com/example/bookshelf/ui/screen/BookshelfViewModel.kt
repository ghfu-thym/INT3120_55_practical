package com.example.bookshelf.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.BookshelfApplication
import com.example.bookshelf.data.BookThumbNailRepository
import com.example.bookshelf.model.ImageLink
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface UiState {
    data class Success(val bookThumbnail: List<ImageLink>) : UiState
    object Error : UiState
    object Loading : UiState
}

class BookshelfViewModel(
    private val book: BookThumbNailRepository
) : ViewModel() {
    var uiState: UiState by mutableStateOf(UiState.Loading)
        private set

    init {
        getBookThumbnails()
    }

    fun getBookThumbnails() {
        viewModelScope.launch {
            uiState = UiState.Loading
            uiState = try {
                UiState.Success(book.getBookThumbnails())
            } catch (e: IOException) {
                UiState.Error
            }
        }
    }
    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookshelfApplication)
                val bookThumbNailRepository =application.container.bookThumbNailRepository
                BookshelfViewModel(book = bookThumbNailRepository)

            }
        }
    }
}