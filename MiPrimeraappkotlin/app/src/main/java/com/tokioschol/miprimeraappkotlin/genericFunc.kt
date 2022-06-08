package com.tokioschol.miprimeraappkotlin

infix fun String.agregar(value:String):String = this.plus(value)

val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

fun executeIfTrue(condition:Boolean,block:()->Unit){
    if (condition!=null && condition==true) block else print("don't execute func")
}