import kotlin.properties.Delegates

// Funciones con varios parámetros de entrada.
fun suma(a: Int, b: Int): Int {
    return a + b
}

fun suma(vararg valores:Int): Int
{
    var sumaTotal=0
    for(valor in valores)
    {
        sumaTotal+=valor
    }
    return sumaTotal
}

println("La suma de números del 1 al 10 es: "+suma(1,2,3,4,5,6,7,8,9,10))


data class Punto(val x: Int, val y:Int)

class Poligono(vararg val puntos: Punto) {
    init {
        require(puntos.size >= 3) { "Un polígono debe tener al menos 3 puntos" }
    }

    override fun toString(): String {
        return "Poligono(puntos=${puntos.contentToString()})"
    }

}
val pol1:Poligono=Poligono(Punto(0,0), Punto(1,0), Punto(0,1))
println(pol1)


// PROGRAMACIÓN ORIENTADA A OBJETOS
// Clases
data class Coche(val cilindrada:Int, val matricula:String)
{
    lateinit var chasis:Chasis
    var ruedas=Array<Rueda?>(4){null}

    constructor ():this(0, "")

    inner class Chasis(val material:String)
    {
        override fun toString(): String {
            return "Chasis de $material en un coche de cilindrada $cilindrada y matrícula $matricula"
        }
    }

    inner class Rueda(var marca:String)
    {
        override fun toString(): String {
            return "Rueda $marca"
        }
    }

    override fun toString(): String {
        return "Coche(cilindrada=$cilindrada, matricula='$matricula', chasis=$chasis, ruedas=${ruedas.contentToString()})"
    }

}

val coche:Coche=Coche(2000, "1234ABC")
val chasis:Coche.Chasis=coche.Chasis("Aluminio")
coche.chasis=chasis
for (i in 0..3)
{
    coche.ruedas[i]=coche.Rueda("Michelin")
}

println(coche)


//Funciones que reciben parámetros que son otra función.
fun sumaParesValores(valor1:Int,valor2:Int):Int
{
    return valor1+valor2
}
fun restaParesValores(valor1:Int,valor2:Int):Int {
    return valor1 - valor2
}

fun ejecutaOpercion(operacion:(Int,Int)->Int, valor1:Int, valor2:Int):Int
{
    return operacion(valor1,valor2)
}

println(ejecutaOpercion(::sumaParesValores, 10, 5))
println(ejecutaOpercion(::restaParesValores, 10, 5))



// Funciones con Lambdas
val multiplacion={valor1:Int, valor2:Int->valor1*valor2}
val saludar={println("Hola mundo")}
val cuadrado={valor:Int->valor*valor}
val multiplicacion2:(Int,Int)->Int={valor1,valor2->valor1*valor2}
println(multiplacion(5,5))
saludar()
println(cuadrado(5))
println(multiplicacion2(5,5))

// Ejemplo con variables by lazy
val lazyValue: String by lazy {
    println("Inicializando lazyValue")
    "Hola"
}
println(lazyValue)
println(lazyValue)


// Ejemplo con observable
var nombre: String by Delegates.observable("Sin nombre") 
{ prop, old, new ->    println("$old -> $new")}
nombre="Juan"
nombre="Pedro"























