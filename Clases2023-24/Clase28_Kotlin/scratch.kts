

println("HOla mundo")

var numero=0
numero++
println(numero)
var cadena:String ="Hola mundo"
println(cadena)
val otraCadena:String ="Hola mundo2"
cadena="Hola mundo3"

var soltero:Boolean=true
var edad:Int=33
var altura:Double=1.75
var peso:Float=75.0f
var inicial:Char='A'

println("Valor soltero $soltero longitud de cadena ${cadena.length}")


//Estructuras de control
if (soltero)
    println("Soltero")
else
    println("Otro")

if (soltero && edad>18)
    println("Soltero mayor de edad")
else
    println("Soltero menor de edad")

var resultado=if (soltero) "Soltero" else "Casado"
println(resultado)


var posibleNulo:String?=null
if (posibleNulo.isNullOrBlank())
    println("Está vacío")
else
    println("No está vacío")


when (edad) {
    0 -> println("Recién nacido")
    in 1..5-> println("Infante")
    6,7,8,9,10,11,12 -> println("Niño")
    in 13..18 -> println("Adolescente")
    in 19..30 -> println("Joven")
    in 31..60 -> println("Adulto")
    else -> println("Anciano")
}

var fecha:String ="2024-04-17"
when (fecha.subSequence(5, 7)) {
    "01" -> println("Enero")
    "02" -> println("Febrero")
    "03" -> println("Marzo")
    "04" -> println("Abril")
    else -> println("Otro mes")
}

var resultadoFecha=when (fecha.subSequence(5, 7)) {
    "01" -> "Enero"
    "02" -> "Febrero"
    "03" -> "Marzo"
    "04" -> "Abril"
    else -> "Otro mes"
}
println(resultadoFecha)



//Bucles
var arrayNumeros= arrayOf(10,2,30,44,5)
var arrayNumeros2= arrayOf<Int>(1,8,3,4,5)
var arrayNumeros3= intArrayOf(1,2,3,4,5)
var arrayNumeros4= charArrayOf('a','b','c','d','e')

for (numero in arrayNumeros)
    println(numero)

for(j in 0..arrayNumeros.size-1)
    println("for de toda la vida:" +arrayNumeros.get(j))

var i:Int=0
do {
    println("El numero es ${arrayNumeros2.get(i)}")
    i++
}  while (i<arrayNumeros2.size)

i=0
while (i<arrayNumeros2.size) {
    println("El numero es ${arrayNumeros2.get(i)}")
    i++
}

// Array STring
var arrayString= arrayOf("a","b","c","d","e")

var arrayString21=arrayOf<String>("a","b","c","d","e")
for (cadena in arrayString21)
    println(cadena)

//Array bidimensional
var arrayBidimensional= arrayOf(arrayOf(1,2,3),arrayOf(4,5,6),arrayOf(7,8,9))
var arrayBidimensional2= arrayOf(intArrayOf(3,2,1),intArrayOf(6,5,4),intArrayOf(9,8,7))

i=0
for (i in arrayBidimensional.indices) {
    for (j in arrayBidimensional[i].indices) {
        print("${arrayBidimensional[i][j]+arrayBidimensional2[i][j]} ")
    }
    println()
}


var a=3
var b=4
println("La suma de $a mas $b es: ${suma(a, b)}")



//Colecciones
var mi_set:Set<Int> = setOf(1, 4, 3, 4, 4)
mi_set=setOf(8,8,3,1,2)
println(mi_set)
var mi_setVariable:MutableSet<Int> = mutableSetOf(1, 4, 3, 4, 4)
mi_setVariable.add(5)
mi_setVariable.add(5)
mi_setVariable.remove(4)
println(mi_setVariable)









/*
fun suma(a: Int, b: Int): Int {
    return a + b
}*/
fun suma(a:Int, b: Int) = a + b
