package com.example.clase32_kotlinrecyclerviewlivedata

class PersonaProvider {
    companion object {
        fun getPersonas(): MutableList<Persona> {
            return mutableListOf(
                Persona("Juan", 20),
                Persona("Pedro", 30),
                Persona("Maria", 40),
                Persona("Ana", 50),
                Persona("Luis", 60),
                Persona("Carlos", 70),
                Persona("Jose", 80),
                Persona("Jorge", 90),
                Persona("Miguel", 100),
                Persona("Ricardo", 110),
                Persona("Fernando", 120),
                Persona("Rodrigo", 130),
                Persona("Raul", 140),
                Persona("Roberto", 150),
                Persona("Ramon", 18),
                Persona("Ricardo", 17),
                Persona("Rafael", 18),
                Persona("Raul", 19),
                Persona("Ricardo", 20),

                Persona("Ricardo", 22)
            )
        }
    }
}