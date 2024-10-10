package com.example.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class BookInfo(
    val id: String,
    val imageLinks: ImageLink
)

@Serializable
data class ImageLink(
    val smallThumbnail: String,
    val thumbnail: String,
){
    val httpsLink: String
        get()=thumbnail.replace("http", "https")
}