package com.example.recyclerviewbasic.model

import androidx.annotation.DrawableRes

data class Sword(
    val id: Int,
    val name: String,
    val damage: Int,
    val velocity: String,
    val origin: String,
    @DrawableRes
    val image: Int
)
