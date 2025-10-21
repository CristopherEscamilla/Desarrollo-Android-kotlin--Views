package com.example.menus_listas_nav.data

import com.example.menus_listas_nav.models.Book


fun obtenerListaDeLibros(): List<Book> {
    return listOf(
        Book(1, "Dune", "Frank Herbert", "ciencia ficcion", 1965),
        Book(2, "1984", "George Orwell", "ciencia ficcion", 1949),
        Book(3, "Fahrenheit 451", "Ray Bradbury", "ciencia ficcion", 1953),
        Book(4, "Neuromancer", "William Gibson", "ciencia ficcion", 1984),
        Book(5, "El juego de Ender", "Orson Scott Card", "ciencia ficcion", 1985),
        Book(6, "La guía del autoestopista galáctico", "Douglas Adams", "ciencia ficcion", 1979),
        Book(7, "Fundación", "Isaac Asimov", "ciencia ficcion", 1951),
        Book(8, "Soy leyenda", "Richard Matheson", "ciencia ficcion", 1954),
        Book(9, "Los desposeídos", "Ursula K. Le Guin", "ciencia ficcion", 1974),
        Book(10, "Crónicas marcianas", "Ray Bradbury", "ciencia ficcion", 1950),
        Book(11, "Hyperion", "Dan Simmons", "ciencia ficcion", 1989),
        Book(12, "Snow Crash", "Neal Stephenson", "ciencia ficcion", 1992),
        Book(13, "Solaris", "Stanisław Lem", "ciencia ficcion", 1961),
        Book(14, "El hombre en el castillo", "Philip K. Dick", "ciencia ficcion", 1962),
        Book(15, "El fin de la infancia", "Arthur C. Clarke", "ciencia ficcion", 1953),

        Book(16, "Cien años de soledad", "Gabriel García Márquez", "novela", 1967),
        Book(17, "Orgullo y prejuicio", "Jane Austen", "novela", 1813),
        Book(18, "Matar a un ruiseñor", "Harper Lee", "novela", 1960),
        Book(19, "El gran Gatsby", "F. Scott Fitzgerald", "novela", 1925),
        Book(20, "Crimen y castigo", "Fiódor Dostoyevski", "novela", 1866),
        Book(21, "Don Quijote de la Mancha", "Miguel de Cervantes", "novela", 1605),
        Book(22, "Los hermanos Karamazov", "Fiódor Dostoyevski", "novela", 1880),
        Book(23, "Jane Eyre", "Charlotte Brontë", "novela", 1847),
        Book(24, "El señor de los anillos", "J.R.R. Tolkien", "novela", 1954),
        Book(25, "Las uvas de la ira", "John Steinbeck", "novela", 1939),
        Book(26, "La metamorfosis", "Franz Kafka", "novela", 1915),
        Book(27, "Lolita", "Vladimir Nabokov", "novela", 1955),
        Book(28, "Cumbres borrascosas", "Emily Brontë", "novela", 1847),
        Book(29, "La peste", "Albert Camus", "novela", 1947),
        Book(30, "1984", "George Orwell", "novela", 1949),

        Book(
            1,
            "Android Programming: The Big Nerd Ranch Guide",
            "Bill Phillips, Chris Stewart, Kristin Marsicano",
            "programación Android",
            2021
        ),
        Book(
            2,
            "Head First Android Development",
            "Dawn Griffiths, David Griffiths",
            "programación Android",
            2017
        ),
        Book(
            3,
            "Android App Development For Dummies",
            "Michael Burton",
            "programación Android",
            2015
        ),
        Book(
            4,
            "How to Build Android Apps with Kotlin",
            "Alex Forrester",
            "programación Android",
            2020
        ),
        Book(
            5,
            "Kickstart Modern Android Development with Jetpack and Kotlin",
            "Artem Mostovenko",
            "programación Android",
            2021
        )


    )
}

