import com.example.clase29_orientacionobjetoskotlin.ColorFavorito
import com.example.clase29_orientacionobjetoskotlin.Persona
import com.example.clase29_orientacionobjetoskotlin.Persona2


val pedro: Persona = Persona("Pedro",30, "Calle Mayor")

print("Datos del objeto: $pedro")

val pedro2: Persona2 = Persona2("Pedro",30, "Calle Mayor",ColorFavorito.VERDE_C)
print("Datos del objeto: $pedro2")
//pedro2.edad=40

println("------------------")
//Create ArrayList
var lista:ArrayList<Persona2> = ArrayList<Persona2>()
val juan:Persona2 = Persona2("Juan", 30, "Calle Mayor",ColorFavorito.ROJO_O)
val maria:Persona2 = Persona2("Maria", 25, "Calle Menor",ColorFavorito.AZUL_C)
lista.add(juan)
lista.add(maria)
lista.add(1,Persona2("Luisa", 25, "Calle Menor",ColorFavorito.VERDE_O))
for (persona in lista) {
    println("Datos del objeto: $persona")
}

//Trabajando con Mapas
val map:HashMap<String,Persona2> = HashMap<String, Persona2>()
for (persona in lista) {
    map.put(persona.nombre,persona)
}
map.put("Victor",Persona2("Victor"))
print("Datos del objeto: ${map.get("Juan")}")
print("Datos del objeto: ${map.get("Victor")}")

pedro2.saludo("Juan")


object Coche {
    var marca:String="Seat"
    var modelo:String="Ibiza"
    var color:String="Rojo"
    var velocidad:Int=0
    fun acelerar() {
        velocidad+=10
    }
    fun frenar() {
        velocidad-=10
    }

    override fun toString(): String {
        return "Coche(marca='$marca', modelo='$modelo', color='$color', velocidad=$velocidad)"
    }

}

//IMprimir datos del objeto
Coche.acelerar()
println(Coche.toString())



// let sobre Persona2
val persona = Persona2("Juanillo", 30, "Calle Mayor",ColorFavorito.ROJO_O)
var longitudNombre:Int= persona.let {
    it.saludo("Juan, soy ${it.nombre}")
    it.despedida("Juan, soy ${it.nombre}")
    it.nombre="Alfredo"
    it.saludo("Juan, soy ${it.nombre}")
    it.despedida("Juan, soy ${it.nombre}")
    it.nombre.length
}
println("Longitud del nombre: $longitudNombre")

// apply sobre Persona2
persona.apply {
    saludo("Juan, soy ${nombre}")
    despedida("Juan, soy ${nombre}")
    nombre="Alfredo2"
    saludo("Juan, soy ${nombre}")
    despedida("Juan, soy ${nombre}")
}
println("-----------------------")
var malena:Persona2=Persona2("Malena").apply {
    nombre="Malena2"
    edad=18
    direccion="Calle Mayor"
    println(toString())
}.also { it.saludo("Juan, soy ${it.nombre}") }






