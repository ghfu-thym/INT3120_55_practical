package com.example.bookshelf.data

import com.example.bookshelf.network.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

interface AppContainer {
    val bookThumbNailRepository: BookThumbNailRepository
}

class DefaultAppContainer :AppContainer{
    private val BaseUrl= "https://www.googleapis.com/books/v1/"

    private val retrofit: Retrofit= Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BaseUrl)
        .build()
    private val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val bookThumbNailRepository: BookThumbNailRepository by lazy {
        NetworkBookThumbnailsRepository(retrofitService)
    }

}