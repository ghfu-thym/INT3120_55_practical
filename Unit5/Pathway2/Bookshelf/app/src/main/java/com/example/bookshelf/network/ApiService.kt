package com.example.bookshelf.network

import com.example.bookshelf.model.BookInfo
import retrofit2.http.GET

interface ApiService {
    //get all book about jazz history
    @GET("volumes?q=jazz+history")
    suspend fun getBookInfo(): List<BookInfo>
}