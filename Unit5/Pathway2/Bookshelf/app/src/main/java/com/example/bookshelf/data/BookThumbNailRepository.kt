package com.example.bookshelf.data

import com.example.bookshelf.model.BookInfo
import com.example.bookshelf.model.ImageLink
import com.example.bookshelf.network.ApiService

interface BookThumbNailRepository {
    suspend fun getBookThumbnails(): List<ImageLink>
}

class NetworkBookThumbnailsRepository(
    private val apiService: ApiService
): BookThumbNailRepository {
    override suspend fun getBookThumbnails(): List<ImageLink> = apiService.getBookInfo().map {
        it.imageLinks.copy(thumbnail = it.imageLinks.httpsLink)
    }
}


    /*{
        val bookInfo = apiService.getBookInfo()
        val imageLinks: List<ImageLink> = bookInfo.map { it.imageLinks.copy(thumbnail = it.imageLinks.httpsLink) }
        return imageLinks
    }
}*/