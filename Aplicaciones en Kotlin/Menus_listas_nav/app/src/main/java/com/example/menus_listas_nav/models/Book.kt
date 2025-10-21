package com.example.menus_listas_nav.models

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val genre: String,
    val publicationYear: Int,

){
    override fun toString(): String {
        return "$title"
    }
}
