package com.example.clase42_peliculas_final

object PeliculasData {
    val peliculas = listOf(
        Pelicula(
            titulo = "Inception",
            director = "Christopher Nolan",
            imagenUrl = "https://upload.wikimedia.org/wikipedia/ca/e/ea/Inception.jpg",
            valoracion = 5,
            descripcion = "A mind-bending thriller about dream invasion."
        ),
        Pelicula(
            titulo = "The Matrix",
            director = "Lana Wachowski, Lilly Wachowski",
            imagenUrl = "https://m.media-amazon.com/images/I/51Ttvb17dtL._SX300_SY300_QL70_ML2_.jpg",
            valoracion = 4,
            descripcion = "A hacker discovers the reality is a simulation and joins a rebellion."
        ),
        Pelicula(
            titulo = "El milagro de P.Tinto",
            director = "Javier Fesser",
            imagenUrl = "https://www.tapasmagazine.es/wp-content/uploads/2020/08/Duu2pzmW4AAfU5I.jpg",
            valoracion = 3,
            descripcion = "Pelíca cómica española sobre un hombre que quiere ser padre."
        ),
    )
}

data class Pelicula(
    val titulo: String,
    val director: String,
    val imagenUrl: String,
    val valoracion: Int,
    val descripcion: String,
    var vista: Boolean = false
)
