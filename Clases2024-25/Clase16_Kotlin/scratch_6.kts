//var numero=0
var numero:Int=0
numero=34
print("El valor de numero es: $numero")

val numero2:Int= 45
//numero2= 56
print("El valor de numero2 es: $numero2")

val nombre:String="Juan"
val peso:Double= 78.5
val edad:Int= 34
val esEstudiante:Boolean= true


if (edad>18) {
    print("Es mayor de edad")
}

var resultado=if (edad>18)  "Es mayor de edad"  else   "Es menor de edad"

print(resultado)

var posibleNulo:String?=null
print("El valor de posibleNulo es: ${posibleNulo?.length?:"No tiene valor"}")

val numero1:Int?=  null
print((numero1?:0)*2)


when (edad) {
    in 0..17 -> print("Es menor de edad")
    in 18..65 -> print("Es mayor de edad")
    else -> print("Es un anciano")
}
val fechas:String = "2025-04-03"
var mes=when (fechas.subSequence(5,7).toString().toInt()) {
    1 -> "Enero"
    2 -> "Febrero"
    3 -> "Marzo"
    4 -> "Abril"
    5 -> "Mayo"
    6 -> "Junio"
    7 -> "Julio"
    8 -> "Agosto"
    9 -> "Septiembre"
    10 -> "Octubre"
    11 -> "Noviembre"
    12 -> "Diciembre"
    else -> "No existe el mes"
}
print("El mes es: $mes")


var arrayNumeros= arrayOf<Int>(1,2,3,4,5)

for (i in 0..arrayNumeros.size-1){
    println("El valor de la posicion $i es: ${arrayNumeros[i]}")
    arrayNumeros[i]=arrayNumeros[i]*2
}
for (i in arrayNumeros){
    println("El valor de la posicion $i es: $i")
}

// Colecciones
//var miConjuntoDatos:Set<Int> = setOf(1,2,3,4,5,6,7,1,2,3,4,)
/*var miConjuntoDatos:MutableSet<Int> = mutableSetOf(1,2,3,4,5,6,7,1,2,3,4,)
var posicion=0
for (i in miConjuntoDatos){
    println("->El valor de la posicion $i es: $i")
    miConjuntoDatos.remove(posicion)
    miConjuntoDatos.add(i*2)
}
println("---------------")
for (i in miConjuntoDatos){
    println("El valor de la posicion $i es: $i")
}*/

fun suma(num1:Int=0, num2:Int=0):Int{
    return num1+num2
}

//println(suma(3,5))
println(suma())
fun suma(num1:Int=0, num2:Int=0, num3:Int=0):Int = num1+num2

fun suma(vararg numeros:Int):Int{
    var resultado=0
    for (i in numeros){
        resultado+=i
    }
    return resultado
}

